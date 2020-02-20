package org.smacknologs.observer;

public class NewsChannel implements WeatherObserver {

	public NewsChannel(WeatherData wd) {
		wd.addObserver(this);
	}
	
	@Override
	public void update(WeatherData o) {
		
		
	}

	

	

}
