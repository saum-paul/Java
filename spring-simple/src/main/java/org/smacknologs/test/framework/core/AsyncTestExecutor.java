package org.smacknologs.test.framework.core;

import org.smacknologs.test.Observable.Observer;
import org.smacknologs.test.framework.ExecutorTask;
import org.smacknologs.test.framework.TestCase;
import org.smacknologs.test.framework.entity.TestExecution;

public class AsyncTestExecutor extends AbstractTestExecutor {

    public AsyncTestExecutor(TestRepository testStore, TestContext testContext, Observer testObserver) {
	super(testStore, testContext, testObserver);
    }

    @Override
    protected void doExecute(TestCase testCase, TestExecution testExecution) {
	Thread t = new Thread(new ExecutorTask(testCase, testExecution));
	t.start();
    }

}
