package org.smacknologs.test.framework.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.smacknologs.test.framework.TestInstanceVO;

public class MapTestContext implements TestContext {

    private static final Logger LOGGER = LogManager.getLogger(MapTestContext.class);

    private Map<IndexKey, TestInstanceVO> contextMap;

    private String applicationName;

    private TestRepository testStore;

    public MapTestContext(String applicationName, TestRepository testStore) {
	this.applicationName = applicationName;
	this.testStore = testStore;
    }

    public void init() {

	if (null == contextMap) {
	    List<TestInstanceVO> testInstances = testStore.getTestInstances(this.applicationName);
	    if (testInstances.isEmpty()) {
		LOGGER.warn("No Tests configured for Application - " + this.applicationName);
		return;
	    }
	    contextMap = new HashMap<>();

	    for (TestInstanceVO testInstanceVO : testInstances)
		contextMap.put(new IndexKey(testInstanceVO.getEnvName(), testInstanceVO.getTestName()), testInstanceVO);
	}
    }

    @Override
    public TestInstanceVO getInstance(String testName, String environment) {
	return contextMap.get(new IndexKey(environment, testName));
    }

    @Override
    public String getApplication() {
	return this.applicationName;
    }

    static class IndexKey {
	private String envName;
	private String testCase;

	public IndexKey(String envName, String testCase) {
	    this.envName = envName;
	    this.testCase = testCase;
	}
    }
}
