package org.smacknologs.observer;

public interface WeatherData{
	
	public void addObserver(WeatherObserver o);

	public void removeObserver(WeatherObserver o);
	
	public void notifyObserver();
	
	public double getTemperature();
	
	public double getHumidity();

}
