package org.smacknologs.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CsvFileProcessor extends FileProcessor {

	@Override
	boolean validate(String fileName) {
		return fileName.toLowerCase().endsWith(".csv");
	}

	@Override
	void processFile(String fileName) {
		try (BufferedReader br = new BufferedReader(
				new FileReader(fileName))) {
			String line;
			if (null != (line = br.readLine())) {
				String words[] = line.split(",");
				System.out.println(Arrays.toString(words));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
