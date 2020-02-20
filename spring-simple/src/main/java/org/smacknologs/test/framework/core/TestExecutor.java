package org.smacknologs.test.framework.core;

public interface TestExecutor {

    /**
     * 
     * @param testName
     * @param environment
     */
    Long run(String testName, String environment);

}
