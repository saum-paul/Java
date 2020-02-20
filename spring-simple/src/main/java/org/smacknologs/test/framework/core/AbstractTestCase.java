package org.smacknologs.test.framework.core;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Objects;

import org.smacknologs.test.framework.InputCollector;
import org.smacknologs.test.framework.InputValidator;
import org.smacknologs.test.framework.TestCase;
import org.smacknologs.test.framework.TestInputs;
import org.smacknologs.test.framework.Step.StepException;
import org.smacknologs.test.framework.core.TestResult.Outcome;
import org.smacknologs.test.framework.entity.TestExecution;
import org.smacknologs.test.framework.entity.TestExecution.TestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public abstract class AbstractTestCase implements TestCase {

    private String name;
    private String env;

    public AbstractTestCase(String name) {
	this.name = Objects.requireNonNull(name, "Test Case Name cannot be null");
    }

    protected String getEnv() {
	return this.env;

    }

    // List of steps
    protected abstract TestResult doExecute(TestInputs data, TestExecution testExecution) throws StepException;

    @Override
    public void execute(TestExecution testExecution) {
	Assert.notNull(testExecution, "Test Execution cannot be null");

	this.env = testExecution.getTestInstance().getEnvName();

	TestInputs data = getInputCollector().collectInputs(env);

	this.validator().validate(data);

	testExecution.setStatus(TestStatus.RUNNING);

	try {
	    TestResult result = doExecute(data, testExecution);

	    if (Outcome.SUCCESS == result.getOutcome()) {
		testExecution.setSummary(result.getSummary());
		testExecution.setStatus(TestStatus.SUCCESS);
	    } else {
		testExecution.setSummary(result.getSummary());
		testExecution.setStatus(TestStatus.FAILED);
	    }
	} catch (Exception e) {
	    testExecution.setSummary("Error while running " + getName());
	    testExecution.setStatus(TestStatus.ERROR);
	}
    }

    @Override
    public String getName() {
	return name;
    }
}
