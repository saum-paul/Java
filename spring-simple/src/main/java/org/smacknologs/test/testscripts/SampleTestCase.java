package org.smacknologs.test.testscripts;

import org.smacknologs.test.framework.InputCollector;
import org.smacknologs.test.framework.InputValidator;
import org.smacknologs.test.framework.TestInputs;
import org.smacknologs.test.framework.Step.StepException;
import org.smacknologs.test.framework.core.AbstractTestCase;
import org.smacknologs.test.framework.core.TestResult;
import org.smacknologs.test.framework.core.TestResult.Outcome;
import org.smacknologs.test.framework.entity.TestExecution;

public class SampleTestCase extends AbstractTestCase {

    private InputValidator validator;
    private InputCollector collector;

    public SampleTestCase(String name, InputValidator validator, InputCollector collector) {
	super(name);
	this.validator = validator;
	this.collector = collector;
    }

    @Override
    public InputValidator validator() {
	return this.validator;
    }

    @Override
    public InputCollector getInputCollector() {
	return this.collector;
    }

    @Override
    protected TestResult doExecute(TestInputs data, TestExecution testExecution) throws StepException {
	return new TestResult(Outcome.SUCCESS, "Expected this, got this");
	
    }

}
