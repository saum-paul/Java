package org.smacknologs.test.framework;

import org.smacknologs.test.framework.entity.TestExecution;

/**
 * @author Saum
 *
 */
public interface TestCase {

    /**
     * Execute test case and capture the state in TestExecution
     * 
     * @param testExecution
     */
    void execute(TestExecution testExecution);

    String getName();

    InputValidator validator();

    InputCollector getInputCollector();
}
