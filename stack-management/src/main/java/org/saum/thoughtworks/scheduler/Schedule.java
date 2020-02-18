package org.saum.thoughtworks.scheduler;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * The Schedule for the Topics
 * 
 * @author Saum
 *
 */
public class Schedule {

	private List<Track> tracks;

	public Schedule(List<Track> tracks) {
		this.tracks = Objects.requireNonNull(tracks, "Track cannot be null");
	}

	public List<Track> getTracks() {
		return tracks;
	}

	@Override
	public String toString() {
		String date = getTracks().get(0).getStartTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
		StringBuilder sb = new StringBuilder("\nSchedule for: ").append(date).append("\n");
		getTracks().forEach(sb::append);
		return sb.toString();
	}
}
