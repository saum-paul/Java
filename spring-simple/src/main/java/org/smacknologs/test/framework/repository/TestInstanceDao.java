package org.smacknologs.test.framework.repository;

import java.util.List;

import org.smacknologs.test.framework.TestInstanceVO;

public interface TestInstanceDao {
    
    List<TestInstanceVO> findByApp(String appName);

}
