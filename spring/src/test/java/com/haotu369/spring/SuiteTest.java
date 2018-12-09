package com.haotu369.spring;

import com.haotu369.spring.v1.ApplicationContextTestV1;
import com.haotu369.spring.v1.BeanFactoryTestV1;
import com.haotu369.spring.v1.ResourceTestV1;
import com.haotu369.spring.v1.SuiteTestV1;
import com.haotu369.spring.v2.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/29
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        SuiteTestV1.class,
        SuiteTestV2.class
})
public class SuiteTest {

}
