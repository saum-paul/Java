package org.smacknologs.test.framework.repository;

import java.time.LocalDateTime;

import org.smacknologs.test.framework.entity.TestExecution;
import org.smacknologs.test.framework.entity.TestExecution.TestStatus;

public interface TestExecutionDao {

    Long create(Long testInstanceId, TestStatus status, LocalDateTime startTime, LocalDateTime lastUpdated);

    void update(TestExecution testExecution);

}
