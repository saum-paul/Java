package org.smacknologs.patterns.factory.apps;

import java.util.HashMap;

public class AppFactory {
	private HashMap<String, AppFactoryAPI> appIndex;

	private interface AppFactoryAPI {
		Apps execute();
	}

	public AppFactory() {
		appIndex = new HashMap<>();
		appIndex.put("weather", () -> new WeatherApp());
		appIndex.put("gmail", () -> new MailClientApp("GMAIL"));
		appIndex.put("outlook", () -> new MailClientApp("OUTLOOK"));
	}

	public Apps makeApp(String appType) {
		AppFactoryAPI factoryAPI = appIndex.get(appType);
		if (null != factoryAPI)
			return factoryAPI.execute();
		else
			return null;
	}

}
