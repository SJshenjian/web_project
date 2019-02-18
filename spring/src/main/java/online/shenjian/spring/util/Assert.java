package online.shenjian.spring.util;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/16
 */
public abstract class Assert {

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
