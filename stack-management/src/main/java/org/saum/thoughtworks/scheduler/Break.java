package org.saum.thoughtworks.scheduler;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Enum for all types of breaks.
 * @author Saum
 *
 */
public enum Break {
	LUNCH(LocalTime.NOON, 60L);

	private LocalTime startTime;
	private Duration duration;

	Break(LocalTime startTime, long duration) {
		this.startTime = startTime;
		this.duration = Duration.ofMinutes(duration);
	}

	public Event apply() {
		switch (this) {
		case LUNCH:
			ZonedDateTime eventStartTime = startTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault());
			return new Event("LUNCH", eventStartTime, this.duration);

		}
		throw new AssertionError("Unknown EventType" + this);
	}
}
