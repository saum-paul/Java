package org.smacknologs.test.framework;

/**
 * Encapsulates test and env data, must be immutable.
 * 
 * @author Saum
 *
 */
public class TestInstanceVO {

    private Long id;
    private String testName;
    private String beanName;
    private String envName;

    public TestInstanceVO(Long id, String testName, String beanName, String envName) {
	this.id = id;
	this.testName = testName;
	this.beanName = beanName;
	this.envName = envName;
    }

    public Long getId() {
        return id;
    }

    public String getTestName() {
        return testName;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getEnvName() {
        return envName;
    }
}
