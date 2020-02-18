package org.saum.thoughtworks.scheduler;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * 
 * Class holds the Event details.
 * 
 * @author Saum
 *
 */
public class Event {

	private String name;
	private ZonedDateTime startDateTime;
	private Duration duration;

	public Event(String name, ZonedDateTime startDateTime, Duration duration) {
		this.name = name;
		this.startDateTime = startDateTime;
		this.duration = duration;
	}

	public String getName() {
		return this.name;
	}

	public ZonedDateTime getStartTime() {
		return this.startDateTime;
	}

	public Duration getDuration() {
		return this.duration;
	}

	@Override
	public String toString() {
		return new StringBuilder(this.startDateTime.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)))
				.append(" ").append(this.name).append(" ")
				.append(this.duration == null ? "" : this.duration.toMinutes() + " mins ").append("\n").toString();
	}
}
