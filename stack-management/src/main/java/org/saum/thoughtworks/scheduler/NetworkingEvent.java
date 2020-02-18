package org.saum.thoughtworks.scheduler;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Networking Event, enforces start time validation of 16:00
 * 
 * @author Saum
 *
 */
public class NetworkingEvent extends Event {

	private static final LocalTime networingEventTime = LocalTime.parse("16:00:00");

	public NetworkingEvent(ZonedDateTime startDateTime) {
		super("NETWORKING EVENT",
				startDateTime.isBefore(networingEventTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()))
						? networingEventTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault())
						: startDateTime,
				null);

	}

}
