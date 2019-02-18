package online.shenjian.spring;

import online.shenjian.spring.v1.SuiteTestV1;
import com.haotu369.spring.v2.*;
import online.shenjian.spring.v3.SuiteTestV3;
import online.shenjian.spring.v4.SuiteTestV4;
import online.shenjian.spring.v2.SuiteTestV2;
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
        SuiteTestV2.class,
        SuiteTestV3.class,
        SuiteTestV4.class,
})
public class SuiteTest {

}
