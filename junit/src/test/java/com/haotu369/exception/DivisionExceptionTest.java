package com.haotu369.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author : Jian Shen
 * @version : V1.0
 * @date : 2018/7/19
 */
public class DivisionExceptionTest {

    @Test
    public void testDivisionExceptionByFail() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            return ;
        }
        Assert.fail();
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionExceptionByExpected() {
        int result = 10 / 0;
    }
}
