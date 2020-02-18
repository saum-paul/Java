package org.saum.thoughtworks.scheduler;

import java.time.Duration;

/**
 * Class holds the topics
 * 
 * @author Saum
 *
 */
public class Topic {
	private String name;
	private Duration duration;

	public Topic(String name, long durationInMins) {
		this.name = name;
		this.duration = Duration.ofMinutes(durationInMins);
	}

	public String getName() {
		return this.name;
	}

	public Duration getDuration() {
		return this.duration;
	}

	@Override
	public String toString() {
		return new StringBuilder(this.name).append(" (").append(this.duration.toMinutes()).append(" mins)").toString();
	}
}
