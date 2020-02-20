package org.smacknologs.test.framework.collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.smacknologs.test.framework.InputCollector;
import org.smacknologs.test.framework.TestInputs;
import org.smacknologs.test.framework.collectors.CSVInputCollector;

public class CSVInputCollectorTest {

    @Test
    public void testCollectInputs() throws Exception {

	InputCollector ic = new CSVInputCollector(new String[] { "author", "book" }, "", "check.csv");
	
	TestInputs ip = ic.collectInputs("DEV01");
	
	assertNotNull(ip.getString("author"));
	assertNotNull(ip.getString("book"));

    }

}
