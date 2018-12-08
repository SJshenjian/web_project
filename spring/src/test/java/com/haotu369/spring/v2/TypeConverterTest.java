package com.haotu369.spring.v2;

import com.haotu369.spring.beans.SimpleTypeConverter;
import com.haotu369.spring.beans.TypeConverter;
import com.haotu369.spring.beans.TypeMismatchException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/6
 */
public class TypeConverterTest {

    @Test
    public void testConvertStringToInt() {
        TypeConverter converter = new SimpleTypeConverter();
        Integer result = converter.convertIfNecessary("2", Integer.class);
        assertEquals(2, result.intValue());

        try {
           converter.convertIfNecessary("3333s", Integer.class);
        } catch(TypeMismatchException e) {
            return ;
        }
        fail();
    }

    @Test
    public void testConvertStringToBoolean() {
        TypeConverter converter = new SimpleTypeConverter();
        Boolean result = converter.convertIfNecessary("yes", Boolean.class);
        assertEquals(true, result.booleanValue());

        try {
            converter.convertIfNecessary("3333s", Boolean.class);
        } catch(TypeMismatchException e) {
            return ;
        }
        fail();
    }
}
