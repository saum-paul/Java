package org.smacknologs.test.framework.core;

import org.smacknologs.test.Observable.Observer;
import org.smacknologs.test.framework.TestCase;
import org.smacknologs.test.framework.TestInstanceVO;
import org.smacknologs.test.framework.entity.TestExecution;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

public abstract class AbstractTestExecutor implements TestExecutor {

    private ApplicationContext applicationContext;

    private TestContext testContext;

    private TestRepository testStore;
    
    private Observer testObserver;

    public AbstractTestExecutor(TestRepository testStore, TestContext testContext, Observer testObserver) {
	this.testStore = testStore;
	this.testContext = testContext;
	this.testObserver = testObserver;
    }

    @Override
    public Long run(String testName, String environment) {

	Assert.notNull(testName, "Test Case cannot be null");
	Assert.notNull(environment, "Test Environment cannot be null");

	TestInstanceVO testInstance = testContext.getInstance(testName, environment);

	if (null == testInstance)
	    throw new IllegalArgumentException("No Configuration available for [ " + testName + " + ," + environment + " ]");

	TestCase testCase = (TestCase) applicationContext.getBean(testInstance.getBeanName());

	TestExecution testExecution = testStore.createTestExecution(testInstance);
	
	testExecution.register(testObserver);
	
	doExecute(testCase, testExecution);
	
	return testExecution.getId();
    }
    
    protected abstract void doExecute(TestCase testCase, TestExecution testExecution);
}
