package org.saum.thoughtworks.scheduler;

import java.util.List;

public interface Scheduler {

	/**
	 * Generates a schedule from topics
	 * 
	 * @param topics - List of topics to populate
	 * @return
	 */
	Schedule populateSchedule(List<Topic> topics);

}