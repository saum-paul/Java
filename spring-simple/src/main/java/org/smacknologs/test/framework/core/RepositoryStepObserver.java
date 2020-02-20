package org.smacknologs.test.framework.core;

import org.smacknologs.test.Observable;
import org.smacknologs.test.Observable.Observer;
import org.smacknologs.test.framework.entity.StepExecution;

public class RepositoryStepObserver implements Observer {

    TestRepository repository;

    public RepositoryStepObserver(TestRepository repository) {
	this.repository = repository;
    }

    @Override
    public void update(Observable subject) {
	if (subject instanceof StepExecution) {
	    StepExecution entity = (StepExecution) subject;
	    repository.update(entity);
	}
    }
}
