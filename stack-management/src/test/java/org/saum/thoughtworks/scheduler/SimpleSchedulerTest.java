package org.saum.thoughtworks.scheduler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SimpleScheduler
 * 
 * @author Saum
 *
 */
public class SimpleSchedulerTest {

	private static final Logger LOGGER = LogManager.getLogger(SimpleSchedulerTest.class);

	private Schedule schedule;
	private Scheduler scheduler;
	private List<Topic> topics;
	private ScheduleBuilder sb;

	@Before
	public void setUp() {
		topics = new ArrayList<>();
		topics.add(new Topic("1", 45));
		topics.add(new Topic("2", 60));
		topics.add(new Topic("3", 30));
		topics.add(new Topic("4", 60));
		topics.add(new Topic("5", 45));
		topics.add(new Topic("6", 30));
		topics.add(new Topic("7", 25));
		topics.add(new Topic("8", 5));
		topics.add(new Topic("9", 90));
		topics.add(new Topic("10", 45));
		topics.add(new Topic("11", 35));

		sb = new ScheduleBuilder("2019-11-14T09:00:00");
	}

	/**
	 * Create single track schedule without lunch break: total events will be topic
	 * size + 1(networking) total tracks = 1
	 */
	@Test
	public void validateSingleTrackScheduleWithoutLunchBreak() {
		scheduler = new SimpleScheduler(sb);
		schedule = scheduler.populateSchedule(topics);
		LOGGER.debug(schedule);

		assertEquals(12, schedule.getTracks().stream().map(e -> e.size()).mapToInt(Integer::intValue).sum());
		assertEquals(1, schedule.getTracks().size());
	}

	/**
	 * Create dual track schedule without lunch break: 
	 * total events will be (topic size + 1(networking) ) * 2
	 * total tracks = 2
	 */
	@Test
	public void validateDualTrackScheduleWithoutLunchBreak() {
		sb.tracks(2);
		scheduler = new SimpleScheduler(sb);
		schedule = scheduler.populateSchedule(topics);
		LOGGER.debug(schedule);

		assertEquals(13, schedule.getTracks().stream().map(e -> e.size()).mapToInt(Integer::intValue).sum());
		assertEquals(2, schedule.getTracks().size());
	}

	/**
	 * Create dual track schedule with lunch break: 
	 * total events will be (topic size + 2(lunch + networking) ) * 2
	 * total tracks = 2
	 * Lunch time = 12 PM
	 */
	@Test
	public void validateDualTrackScheduleWitLunchBreak() {
		topics.add(new Topic("12", 60));
		topics.add(new Topic("13", 60));
		sb.tracks(2);
		sb.addBreak(Break.LUNCH);
		scheduler = new SimpleScheduler(sb);
		schedule = scheduler.populateSchedule(topics);
		LOGGER.debug(schedule);

		assertEquals(17, schedule.getTracks().stream().map(e -> e.size()).mapToInt(Integer::intValue).sum());
		assertEquals(2, schedule.getTracks().size());
		
		for (Track track : schedule.getTracks()) {
			for (Event event : track) {
				if (event.getName().equals(Break.LUNCH.name())) {
					assertEquals(12, event.getStartTime().getHour());
					assertEquals(0, event.getStartTime().getMinute());
				}

			}
		}
	}

	/**
	 * Create dual track schedule with lunch break: 
	 * total events will be (topic size + 2(lunch + networking) ) * 2
	 * total tracks = 2
	 * Networking time = 4PM
	 */
	@Test
	public void validateDualTrackScheduleWitLunchBreakAndUnderflowingTopics() {
		sb.tracks(2);
		sb.addBreak(Break.LUNCH);
		scheduler = new SimpleScheduler(sb);
		schedule = scheduler.populateSchedule(topics);
		LOGGER.debug(schedule);

		assertEquals(15, schedule.getTracks().stream().map(e -> e.size()).mapToInt(Integer::intValue).sum());
		assertEquals(2, schedule.getTracks().size());
		
		for (Track track : schedule.getTracks()) {
			for (Event event : track) {
				if (event.getName().equalsIgnoreCase("NETWORKING EVENT") ) {
					assertEquals(16, event.getStartTime().getHour());
					assertEquals(0, event.getStartTime().getMinute());
				}
			}
		}
		
	}
	/**
	 * Create dual track schedule with lunch break: 
	 * total events will be LESS THAN (topic size + 2(lunch + networking) ) * 2
	 * total tracks = 2
	 */
	@Test
	public void validateDualTrackScheduleWitLunchBreakAndOverflowingTopics() {
		topics.add(new Topic("12", 60));
		topics.add(new Topic("13", 60));
		topics.add(new Topic("14", 60));
		topics.add(new Topic("15", 60));
		topics.add(new Topic("16", 60));
		topics.add(new Topic("17", 30));
		topics.add(new Topic("18", 10));

		sb.tracks(2);
		sb.addBreak(Break.LUNCH);
		scheduler = new SimpleScheduler(sb);
		schedule = scheduler.populateSchedule(topics);
		LOGGER.debug(schedule);

		
		assertNotEquals(22, schedule.getTracks().stream().map(e -> e.size()).mapToInt(Integer::intValue).sum());
		assertEquals(2, schedule.getTracks().size());
	}

}
