package org.smacknologs.test.framework.core;

import org.smacknologs.test.framework.TestInstanceVO;

public interface TestContext {
    
    String getApplication();

    TestInstanceVO getInstance(String testName, String environment);

}