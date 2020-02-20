package org.smacknologs.test.framework;

/**
 * Not an Entity, should always be immutable.
 * 
 * @author Saum
 *
 */
public class TestVersion {

    private Long testExecutionId;
    private String alternateBeanName;

    public TestVersion(Long testExecutionId, String alternateBeanName) {
	this.testExecutionId = testExecutionId;
	this.alternateBeanName = alternateBeanName;
    }

    public Long getTestExecutionId() {
	return testExecutionId;
    }

    public String getAlternateBeanName() {
	return alternateBeanName;
    }
}
