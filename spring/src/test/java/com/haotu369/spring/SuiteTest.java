package com.haotu369.spring;

import com.haotu369.spring.v1.ApplicationContextTest;
import com.haotu369.spring.v1.BeanFactoryTest;
import com.haotu369.spring.v1.ResourceTest;
import com.haotu369.spring.v2.BeanDefinitionTestV2;
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
        ApplicationContextTest.class,
        ResourceTest.class,
        BeanDefinitionTestV2.class
})
public class SuiteTest {
}
