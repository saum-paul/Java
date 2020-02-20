package org.smacknologs.test.framework.core;

import org.smacknologs.test.Observable.Observer;
import org.smacknologs.test.framework.TestCase;
import org.smacknologs.test.framework.entity.TestExecution;

public class SyncTestExecutor extends AbstractTestExecutor {

    public SyncTestExecutor(TestRepository testStore, TestContext testContext, Observer testObserver) {
	super(testStore, testContext, testObserver);
    }

    @Override
    protected void doExecute(TestCase testCase, TestExecution testExecution) {
	testCase.execute(testExecution);
    }

}
