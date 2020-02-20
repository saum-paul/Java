package org.smacknologs.test.framework.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.smacknologs.test.Entity;
import org.smacknologs.test.Observable;
import org.smacknologs.test.framework.TestInstanceVO;

public class TestExecution extends Entity implements Observable {

    public enum TestStatus {
	QUEUED, RUNNING, SUCCESS, FAILED, ERROR
    }

    private TestInstanceVO testInstance;
    private TestStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime lastUpdated;
    private String summary;

    private List<Observer> observers = new ArrayList<>();

    public TestExecution(Long id, TestStatus status, TestInstanceVO testInstance, LocalDateTime startTime,
	    LocalDateTime lastUpdated) {
	super(id);
	this.testInstance = Objects.requireNonNull(testInstance);
	this.status = status;
	this.startTime = startTime;
	this.lastUpdated = lastUpdated;
    }

    public TestInstanceVO getTestInstance() {
	return testInstance;
    }

    public TestStatus getStatus() {
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

    public void setStatus(TestStatus status) {
	this.status = status;
	this.lastUpdated = LocalDateTime.now();
	this.observers.forEach(this::notify);
    }

    public String getSummary() {
	return summary;
    }

    public void setSummary(String summary) {
	this.summary = summary;
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
