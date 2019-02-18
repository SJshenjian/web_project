package online.shenjian.spring.beans;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/6
 */
public interface TypeConverter {

   <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;
}
