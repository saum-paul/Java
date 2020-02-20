package org.smacknologs.observer;

public class RadioStation implements WeatherObserver {

	private double humidity;

	public RadioStation(WeatherData wd) {
		wd.addObserver(this);
		humidity = 0;
	}

	@Override
	public void update(WeatherData o) {
		if (o.getHumidity() - humidity > 1)
			System.out.println("Humidity increased");

		humidity = o.getHumidity();
	}
}
