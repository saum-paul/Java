package org.smacknologs.test.framework.core;

import org.smacknologs.test.Observable;
import org.smacknologs.test.Observable.Observer;
import org.smacknologs.test.framework.entity.TestExecution;

public class RepositoryTestObserver implements Observer {

    TestRepository repository;

    public RepositoryTestObserver(TestRepository repository) {
	this.repository = repository;
    }

    @Override
    public void update(Observable subject) {
	if (subject instanceof TestExecution) {
	    TestExecution entity = (TestExecution) subject;
	    repository.update(entity);
	}
    }
}
