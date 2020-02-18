package org.saum.thoughtworks;

import org.saum.thoughtworks.scheduler.Topic;

/**
 * Creates topics from input string.
 * @author Saum
 *
 */
public class TopicFactory {

	private static final String PATTERN = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";

	public Topic make(String line) {
		String[] parts = line.split(PATTERN);

		if (parts.length < 2) {
			return new Topic(parts[0].substring(0, parts[0].indexOf(" lightning")), 5L);
		} else
			return new Topic(parts[0], Long.parseLong(parts[1]));
	}

}
