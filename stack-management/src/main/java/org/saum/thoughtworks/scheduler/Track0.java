package org.saum.thoughtworks.scheduler;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Class is a List of Events
 * @author Saum
 *
 */
public class Track0 extends ArrayList<Event> {

	private static final long serialVersionUID = 1L;

	private String name;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private Duration duration;

	public Track0(String name, ZonedDateTime startTime, ZonedDateTime endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = Duration.between(startTime, endTime);
	}

	public boolean addTopic(Topic t, ZonedDateTime eventStartTime) {
		return super.add(new Event(t.getName(), eventStartTime, t.getDuration()));
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public ZonedDateTime getEndTime() {
		return endTime;
	}

	public Duration getDuration() {
		return duration;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("\n").append(this.name).append(":\n");
		this.forEach(sb::append);

		return sb.toString();
	}

}
