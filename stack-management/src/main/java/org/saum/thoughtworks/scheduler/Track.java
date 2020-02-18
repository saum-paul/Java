package org.saum.thoughtworks.scheduler;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class is a List of Events
 * @author Saum
 *
 */
public class Track{

	private String name;
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private Duration duration;
	private List<Event> events;

	public Track(String name, ZonedDateTime startTime, ZonedDateTime endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = Duration.between(startTime, endTime);
		this.events = new ArrayList<>();
	}

	public boolean addTopic(Topic t, ZonedDateTime eventStartTime) {
		return this.events.add(new Event(t.getName(), eventStartTime, t.getDuration()));
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
		this.events.forEach(sb::append);

		return sb.toString();
	}

}
