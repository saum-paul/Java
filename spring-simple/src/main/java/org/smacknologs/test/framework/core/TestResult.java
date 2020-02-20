package org.smacknologs.test.framework.core;

public class TestResult {

    public enum Outcome {
	SUCCESS, FAILURE
    }

    private Outcome outcome;
    private String summary;

    public TestResult(Outcome outcome, String summary) {
	this.outcome = outcome;
	this.summary = summary;
    }

    public Outcome getOutcome() {
	return outcome;
    }

    public String getSummary() {
        return summary;
    }
    
    @Override
    public String toString() {
	return "TestResult [outcome=" + outcome + ", summary=" + summary + "]";
    }

}