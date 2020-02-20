package org.smacknologs.concurrent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadTest {

	private static final Logger LOGGER = LogManager.getLogger();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new ThreadRunnable();
		
		Thread t = new Thread(r);
		t.setName("Hero");
		t.start();
		try {
			t.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.run();
		LOGGER.debug("Thread Started");
		
	}

}
