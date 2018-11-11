package com.haotu369.spring;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/29
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        BeanFactoryTest.class,
        ApplicationContextTest.class
})
public class SuiteTest {
}
