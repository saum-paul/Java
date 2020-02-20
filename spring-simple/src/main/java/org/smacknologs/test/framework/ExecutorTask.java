package org.smacknologs.test.framework;

import org.smacknologs.test.framework.entity.TestExecution;

public class ExecutorTask implements Runnable {
    
    private TestCase testCase;
    private TestExecution testExecution;
    
    public ExecutorTask(TestCase testCase, TestExecution testExecution) {
	this.testCase = testCase;
	this.testExecution = testExecution;
    }

    @Override
    public void run() {
	testCase.execute(testExecution);
    }

}
