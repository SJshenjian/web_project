package online.shenjian.junit.batch.second;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/7/19
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        SecondOneTest.class,
        SecondTwoTest.class
})
public class SecondAllTest {

}
