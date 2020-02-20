package org.smacknologs.test.framework.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.smacknologs.test.Entity;
import org.smacknologs.test.Observable;


public class StepExecution extends Entity implements Observable {

    public enum StepStatus {
	RUNNING, COMPLETE, ERROR
    }

    private TestExecution testExecution;
    private StepStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime lastUpdated;
    private String stepName;
    private List<Observer> observers = new ArrayList<>();

    public StepExecution(Long id, String stepName, StepStatus status, LocalDateTime startTime,
	    LocalDateTime lastUpdated, TestExecution testExecution) {
	super(id);
	this.stepName = stepName;
	this.testExecution = Objects.requireNonNull(testExecution);
	this.status = status;
	this.startTime = LocalDateTime.now();
	this.lastUpdated = LocalDateTime.now();
    }

    public String getStepName() {
	return stepName;
    }

    public TestExecution getTestExecution() {
	return testExecution;
    }

    public StepStatus getStatus() {
	return status;
    }

    public LocalDateTime getStartTime() {
	return startTime;
    }

    public LocalDateTime getEndTime() {
	return endTime;
    }

    public LocalDateTime getLastUpdated() {
	return lastUpdated;
    }

    public void setStatus(StepStatus status) {
	this.status = status;
	this.lastUpdated = LocalDateTime.now();

	if (status.equals(StepStatus.COMPLETE) || status.equals(StepStatus.ERROR))
	    this.endTime = getLastUpdated();

	this.observers.forEach(this::notify);
    }

    @Override
    public void register(Observer o) {
	this.observers.add(o);
    }

    @Override
    public void remove(Observer o) {
	this.observers.remove(o);
    }

    @Override
    public void notify(Observer o) {
	o.update(this);
    }

}
