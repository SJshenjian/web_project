package com.haotu369.spring.v3;

import com.haotu369.spring.beans.factory.support.ConstructorResolver;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/9
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ConstructorResolverTestV3.class,
        BeanDefinitionTestV3.class,
        ApplicationContextTestV3.class
})
public class SuiteTestV3 {
}
