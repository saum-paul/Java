package org.smacknologs.test.framework.core;

import java.util.Objects;

import org.smacknologs.test.Observable.Observer;
import org.smacknologs.test.framework.Step;
import org.smacknologs.test.framework.entity.StepExecution;
import org.smacknologs.test.framework.entity.TestExecution;
import org.smacknologs.test.framework.entity.StepExecution.StepStatus;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractStep<I, O> implements Step<I, O> {

    private String stepName;

    private Observer stepObserver;

    @Autowired
    private TestRepository testStore;
    
    public AbstractStep(String stepName) {
	this(stepName, null);
    }
    
    public AbstractStep(String stepName, Observer stepObserver) {
	this.stepName = Objects.requireNonNull(stepName, "Step-Name cannot be null");
	this.stepObserver = stepObserver;
    }

    protected abstract O doExecute(I input) throws StepException;

    @Override
    public O execute(I input, TestExecution testExecution) throws StepException {
	O output = null;
	StepExecution stepExecution = testStore.createStepExecution(stepName, testExecution);
	stepExecution.register(stepObserver);

	try {
	    output = doExecute(input);
	    stepExecution.setStatus(StepStatus.COMPLETE);
	} catch (Exception e) {
	    stepExecution.setStatus(StepStatus.ERROR);
	    throw e;
	}

	return output;
    }

    public String getName() {
	return stepName;
    }
}
