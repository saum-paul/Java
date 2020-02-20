package org.smacknologs.test.framework.collectors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.smacknologs.test.framework.InputCollector;
import org.smacknologs.test.framework.TestInput;
import org.smacknologs.test.framework.TestInputs;
import org.smacknologs.test.framework.TestInputs.TestInputsBuilder;

/**
 * Gets Data from a CSV file and loads into memory.
 * 
 * @author Saum
 */
public class CSVInputCollector implements InputCollector {

    private String[] header;
    private String basePath;
    private String fileName;
    private Map<String, List<TestInputs>> map = new HashMap<>();

    /**
     * The file name should be of pattern: ENV_TestName.csv
     * @param header
     * @param basePath
     * @param fileName
     */
    public CSVInputCollector(String[] header, String basePath, String fileName) {
	this.header = header;
	this.basePath = basePath;
	this.fileName = fileName;
    }

    protected String getFileName() {
	return fileName;
    }

    protected String[] getHeader() {
	return header;
    }

    @Override
    public TestInputs collectInputs(String env) {
	if (map.isEmpty() || null == map.get(env) || map.get(env).isEmpty()) {
	    List<TestInputs> envTestInputs = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(
		    new FileReader( this.basePath + File.separator +  env + "_" + fileName));
		    CSVParser parser = new CSVParser(br, CSVFormat.DEFAULT.withHeader(header).withDelimiter(',')
			    .withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

		for (CSVRecord csvRecord : parser) {
		    TestInputsBuilder inputBuilder = new TestInputsBuilder();

		    for (String key : header)
			inputBuilder.put(key, TestInput.instanceOf(csvRecord.get(key)));

		    envTestInputs.add(inputBuilder.build());
		}
		map.put(env, envTestInputs);
	    } catch (IOException e) {
		// TODO ADD ERROR LOGS
		throw new RuntimeException(e.getMessage());
	    } 
	}

	List<TestInputs> list = map.get(env);
	if (list.isEmpty())
	    throw new NoSuchElementException("No Data Found For " + env + " in " + this.fileName);

	int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());

	return list.get(randomNum);
    }

}
