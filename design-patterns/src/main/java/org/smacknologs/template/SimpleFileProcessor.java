package org.smacknologs.template;

import java.io.File;

public class SimpleFileProcessor {
	File inputFile;
	FileType fileType;

	enum FileType {
		TEXT, CSV, XML
	};

	public void process() {

		registerFile();

		boolean isValid = false;

		switch (fileType) {

		case TEXT:
			isValid = validateText();
			break;
		case CSV:
			isValid = validateCSV();
			break;
		case XML:
			isValid = validateXML();
			break;
		}
	}

	void registerFile() {

	}

	boolean validateText() {
		return true;

	}

	boolean validateCSV() {
		return true;
	}

	boolean validateXML() {
		return true;
	}
}
