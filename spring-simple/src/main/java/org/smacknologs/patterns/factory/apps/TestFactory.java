package org.smacknologs.patterns.factory.apps;

public class TestFactory {

	public static void main(String[] args) {
		AppFactory factory = new AppFactory();

		Apps weatherApp = factory.makeApp("weather");
		weatherApp.show();
		weatherApp.execute();

		Apps gmail = factory.makeApp("gmail");
		gmail.show();
		gmail.execute();
		Apps outlook = factory.makeApp("outlook");
		outlook.show();
		outlook.execute();

	}

}
