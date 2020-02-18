package org.saum.thoughtworks.scheduler;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Scheduler implementation to populate topics largest first one track at a
 * time.
 * 
 * @author Saum
 *
 */
public class SimpleScheduler implements Scheduler {
	private static final Logger LOGGER = LogManager.getLogger(SimpleScheduler.class);

	private static Comparator<Topic> topicComparator = (o1, o2) -> o2.getDuration().compareTo(o1.getDuration());
	private static Comparator<Event> eventComparator = (o1, o2) -> o1.getStartTime().compareTo(o2.getStartTime());

	private ScheduleBuilder scheduleBuilder;

	/**
	 * @param scheduleBuilder
	 */
	public SimpleScheduler(ScheduleBuilder scheduleBuilder) {
		this.scheduleBuilder = Objects.requireNonNull(scheduleBuilder, "DefaultScheduleBuilder cannot be Null.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.saum.thoughtworks.scheduler.Scheduler#populateSchedule(java.util.List)
	 */
	@Override
	public Schedule populateSchedule(List<Topic> topics) {

		Objects.requireNonNull(topics, "Topics  cannot be Null.");
		Schedule schedule = this.scheduleBuilder.build();

		List<Interval> intervals = findIntervals(schedule);
		topics.sort(topicComparator);

		topics.forEach(t -> addToSchedule(intervals, t));

		intervals.sort((Interval o1, Interval o2) -> {
			int flag = o2.startTime.compareTo(o1.startTime);
			if (flag == 0)
				flag = o2.duration.compareTo(o1.duration);
			return flag;
		});

		// Add Networking event at the last common time available
		schedule.getTracks().forEach(t -> t.add(new NetworkingEvent(intervals.get(0).startTime)));

		schedule.getTracks().forEach(t -> t.sort(eventComparator));

		return schedule;
	}

	/**
	 * Find empty Intervals in a Track.s
	 * 
	 * @param schedule
	 * @return
	 */
	private List<Interval> findIntervals(Schedule schedule) {
		List<Interval> intervals = new ArrayList<>();

		for (Track track : schedule.getTracks()) {

			if (track.isEmpty()) // Schedule doesnt have any pre-defined events
				intervals.add(new Interval(track.getStartTime(), track.getDuration(), track));
			else {
				track.sort(eventComparator);// Assending with StartTime
				
				for (int index = 0; index < track.size(); index++) {
					scanPopulatedTrack(intervals, track, index);
				}
			}
		}
		return intervals;
	}

	/**
	 * Method to find existing events in a track and create intervals
	 *  
	 * @param intervals
	 * @param track
	 * @param index
	 */
	private void scanPopulatedTrack(List<Interval> intervals, Track track, int index) {
		Event event = track.get(index);

		if (index == 0) {
			if (track.getStartTime().isBefore(event.getStartTime())) {

				// Create Interval before the 1st Event
				ZonedDateTime s = track.getStartTime();
				Duration d = Duration.between(s, event.getStartTime());

				intervals.add(new Interval(s, d, track));
			}
			residualInterval(intervals, track, event);
		} else {
			Interval latest = intervals.remove(intervals.size() - 1);

			if (latest.startTime.isBefore(event.getStartTime())) {
				ZonedDateTime s = latest.startTime;
				Duration d = Duration.between(s, event.getStartTime());
				intervals.add(new Interval(s, d, track));
			}
			residualInterval(intervals, track, event);
		}
	}

	/**
	 * Method to Collate time after a scanned event to an Interval
	 * 
	 * @param intervals
	 * @param track
	 * @param event
	 */
	private void residualInterval(List<Interval> intervals, Track track, Event event) {
		// Put the remaining time slot in an Interval
		ZonedDateTime s = event.getStartTime().plusMinutes(event.getDuration().toMinutes());
		Duration d = Duration.between(s, track.getEndTime());
		intervals.add(new Interval(s, d, track));
	}

	private void addToSchedule(List<Interval> intervals, Topic topic) {

		intervals.sort(Comparator.naturalOrder());
		Interval largestInterval = intervals.get(0);

		if (topic.getDuration().compareTo(largestInterval.duration) < 0) {
			largestInterval.track.addTopic(topic, largestInterval.startTime);

			// Remove the Occupied Interval
			intervals.remove(0);

			// Add a new Interval
			ZonedDateTime newStartTime = largestInterval.startTime.plusMinutes(topic.getDuration().toMinutes());
			Duration newDuration = largestInterval.duration.minus(topic.getDuration());

			intervals.add(new Interval(newStartTime, newDuration, largestInterval.track));
		} else {
			LOGGER.warn("Could not fit Topic to Schedule: " + topic);
		}
	}

	private class Interval implements Comparable<Interval> {
		private ZonedDateTime startTime;
		private Duration duration;
		private Track track;

		private Interval(ZonedDateTime startTime, Duration duration, Track track) {
			this.startTime = startTime;
			this.duration = duration;
			this.track = track;
		}

		@Override
		public int compareTo(Interval o) {
			int flag = o.duration.compareTo(this.duration); // Sort Descending
			if (flag == 0)
				flag = this.startTime.compareTo(o.startTime); // Sort Ascending

			return flag;
		}

		@Override
		public String toString() {
			return new StringBuilder(startTime.format(DateTimeFormatter.ISO_LOCAL_TIME)).append(": ")
					.append(this.duration.toMinutes()).toString();
		}
	}
}
