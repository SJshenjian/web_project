package com.haotu369.spring.v2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/9
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        BeanDefinitionTestV2.class,
        BeanDefinitionValueResolverTestV2.class,
        CustomEditorTestV2.class,
        TypeConverterTestV2.class,
        ApplicationContextTestV2.class
})
public class SuiteTestV2 {
}
