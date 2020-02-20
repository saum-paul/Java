package org.smacknologs.concurrent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadRunnable implements Runnable{

	private static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public void run() {
		LOGGER.debug("I'm running");
		
	}

}
