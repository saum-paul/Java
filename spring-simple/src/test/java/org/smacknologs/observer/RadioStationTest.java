package org.smacknologs.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RadioStationTest {
	WeatherData wd;

	@BeforeEach
	void setUp() throws Exception {
		wd = new HourlyWeatherData();
	}

	@Test
	void testRadioStation() {
		RadioStation station = new RadioStation(wd);
		wd.notifyObserver();
	}
}
