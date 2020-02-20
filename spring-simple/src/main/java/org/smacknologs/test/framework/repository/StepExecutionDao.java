package org.smacknologs.test.framework.repository;

import java.time.LocalDateTime;

import org.smacknologs.test.framework.entity.StepExecution;
import org.smacknologs.test.framework.entity.StepExecution.StepStatus;

public interface StepExecutionDao {

    Long create(String stepName, StepStatus status, LocalDateTime startTime, LocalDateTime lastUpdated, Long id);

    void update(StepExecution stepExecution);

}
