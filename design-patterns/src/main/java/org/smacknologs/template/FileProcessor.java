package org.smacknologs.template;

import java.util.Random;

public abstract class FileProcessor {

	public final void process(String fileName) {
		int fileProcessId = registerFile(fileName);

		if (validate(fileName)) {
			updateStatus(fileProcessId, "File is Valid");
			processFile(fileName);
		} else
			updateStatus(fileProcessId, "File is InValid");

		updateStatus(fileProcessId, "Process Complete");

		publish(fileProcessId, fileName);
	}

	int registerFile(String fileName) {
		int fileProcessId = new Random().nextInt();
		return fileProcessId;
	}

	void updateStatus(int processId, String status) {
		System.out.println(processId + ": " + status);
	}

	void publish(int processId, String fileName) {

		System.out.println("File " + fileName
				+ " has been processed, look up the details with process ID:"
				+ processId);

	}

	abstract boolean validate(String fileName);

	abstract void processFile(String fileName);

}
