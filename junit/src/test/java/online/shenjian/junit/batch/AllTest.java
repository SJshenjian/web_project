package online.shenjian.junit.batch;

import online.shenjian.junit.batch.first.FirstAllTest;
import online.shenjian.junit.batch.second.SecondAllTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/7/19
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FirstAllTest.class,
        SecondAllTest.class
})
public class AllTest {
}
