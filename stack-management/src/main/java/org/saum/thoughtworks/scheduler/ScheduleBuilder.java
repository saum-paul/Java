package org.saum.thoughtworks.scheduler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Builder class for constructing empty schedule
 * @author Saum
 *
 */
public class ScheduleBuilder {

	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private int noOfTracks;
	private List<Break> breaks;

	/**
	 * @param startDateTime -  "YYYY-MM-DDTHH:mm:ss+05:30"
	 */
	public ScheduleBuilder(String startDateTime) {
		this.startTime =  LocalDateTime.parse(startDateTime).atZone(ZoneId.systemDefault());
		// Default Values
		this.noOfTracks = 1;
		this.endTime = this.startTime.plusHours(8);
		this.breaks = new ArrayList<>();
	}

	public ScheduleBuilder tracks(int noOfTracks) {
		this.noOfTracks = noOfTracks;
		return this;
	}

	public ScheduleBuilder addBreak(Break b) {
		this.breaks.add(b);
		return this;
	}

	public Schedule build() {
		List<Track> tracks = new ArrayList<>();
		for (int i = 0; i < this.noOfTracks; i++) {
			final Track t = new Track("Track " + (i + 1), this.startTime, endTime);
			breaks.forEach(b -> t.add(b.apply()));
			tracks.add(t);
		}

		return new Schedule(tracks);
	}

}
