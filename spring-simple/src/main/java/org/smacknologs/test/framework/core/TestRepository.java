package org.smacknologs.test.framework.core;

import java.util.List;

import org.smacknologs.test.framework.TestInstanceVO;
import org.smacknologs.test.framework.entity.StepExecution;
import org.smacknologs.test.framework.entity.TestExecution;

public interface TestRepository {

    TestExecution createTestExecution(TestInstanceVO testInstance);

    StepExecution createStepExecution(final String stepName, TestExecution testExecution);

    void update(TestExecution testExecution);

    void update(StepExecution stepExecution);

    List<TestInstanceVO> getTestInstances(String appName);

}
