package org.smacknologs.test.framework;

import org.smacknologs.test.framework.entity.TestExecution;

public interface Step<I, O> {

    public O execute(I input, TestExecution testExecution) throws StepException;

    default <R> Step<I, R> pipe(Step<O, R> next) {
	return (i, t) -> next.execute(execute(i, t), t);
    }

    static <I, O> Step<I, O> of(Step<I, O> next) {
	return next;
    }

    static class StepException extends Exception {
	private static final long serialVersionUID = 1L;

	public StepException(Throwable t) {
	    super(t);
	}
    }

}
