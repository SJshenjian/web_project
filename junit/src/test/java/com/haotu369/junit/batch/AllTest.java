package com.haotu369.junit.batch;

import com.haotu369.junit.batch.first.FirstAllTest;
import com.haotu369.junit.batch.second.SecondAllTest;
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
