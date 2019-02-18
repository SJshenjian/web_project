package online.shenjian.spring.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/9
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        BeanFactoryTestV1.class,
        ApplicationContextTestV1.class,
        ResourceTestV1.class,
})
public class SuiteTestV1 {
}
