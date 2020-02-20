package org.smacknologs.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileProcessor extends FileProcessor {

	@Override
	boolean validate(String fileName) {
		return fileName.toLowerCase().endsWith(".txt");
	}

	@Override
	void processFile(String fileName) {
		try (BufferedReader br = new BufferedReader(
				new FileReader(fileName))) {
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
