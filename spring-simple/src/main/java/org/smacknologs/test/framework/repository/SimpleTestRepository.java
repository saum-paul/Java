package org.smacknologs.test.framework.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.smacknologs.test.framework.TestInstanceVO;
import org.smacknologs.test.framework.core.TestRepository;
import org.smacknologs.test.framework.entity.StepExecution;
import org.smacknologs.test.framework.entity.TestExecution;
import org.smacknologs.test.framework.entity.StepExecution.StepStatus;
import org.smacknologs.test.framework.entity.TestExecution.TestStatus;

public class SimpleTestRepository implements TestRepository {

    TestInstanceDao testInstanceDao;

    TestExecutionDao testExecutionDao;

    StepExecutionDao stepExecutionDao;

    public SimpleTestRepository(TestInstanceDao testInstanceDao, TestExecutionDao testExecutionDao,
	    StepExecutionDao stepExecutionDao) {
	this.testInstanceDao = testInstanceDao;
	this.testExecutionDao = testExecutionDao;
	this.stepExecutionDao = stepExecutionDao;
    }

    @Override
    public TestExecution createTestExecution(TestInstanceVO testInstance) {

	TestStatus status = TestStatus.QUEUED;
	LocalDateTime startTime = LocalDateTime.now();
	LocalDateTime lastUpdated = startTime;

	Long id = testExecutionDao.create(testInstance.getId(), status, startTime, lastUpdated);

	return new TestExecution(id, status, testInstance, startTime, lastUpdated);
    }

    @Override
    public void update(TestExecution testExecution) {

	testExecutionDao.update(testExecution);
    }

    @Override
    public StepExecution createStepExecution(final String stepName, TestExecution testExecution) {

	StepStatus status = StepStatus.RUNNING;
	LocalDateTime startTime = LocalDateTime.now();
	LocalDateTime lastUpdated = startTime;

	Long id = stepExecutionDao.create(stepName, status, startTime, lastUpdated, testExecution.getId());

	return new StepExecution(id, stepName, status, startTime, lastUpdated, testExecution);
    }

    @Override
    public void update(StepExecution stepExecution) {
	stepExecutionDao.update(stepExecution);

    }

    @Override
    public List<TestInstanceVO> getTestInstances(String appName) {
	return testInstanceDao.findByApp(appName);
    }
}
