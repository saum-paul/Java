package org.smacknologs.patterns.factory.apps;

public class MailClientApp extends Apps {
	private String serviceName;

	public MailClientApp(String server) {
		serviceName = server;
	}

	@Override
	void execute() {
		System.out.println("Reding email from: " + serviceName);
	}
}
