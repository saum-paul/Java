package org.smacknologs.observer;

import java.util.ArrayList;
import java.util.List;

public class HourlyWeatherData implements WeatherData {

	List<WeatherObserver> observers;
	private double temperature;
	private double humidity;

	public HourlyWeatherData() {
		observers = new ArrayList<>();
		temperature = 0;
		humidity = 1;
	}

	@Override
	public void addObserver(WeatherObserver o) {
		observers.add(o);
		System.out.println();
	}

	@Override
	public void removeObserver(WeatherObserver o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		for (WeatherObserver weatherObserver : observers) {
			weatherObserver.update(this);
		}
	}

	@Override
	public double getTemperature() {
		return 5;
	}

	@Override
	public double getHumidity() {
		return 5;
	}

}
