package online.shenjian.spring.v2;

import online.shenjian.spring.beans.SimpleTypeConverter;
import online.shenjian.spring.beans.TypeConverter;
import online.shenjian.spring.beans.TypeMismatchException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/6
 */
public class TypeConverterTestV2 {

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
