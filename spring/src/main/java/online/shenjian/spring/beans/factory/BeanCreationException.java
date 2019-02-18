package online.shenjian.spring.beans.factory;

import online.shenjian.spring.beans.BeansException;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/29
 */
public class BeanCreationException extends BeansException {

    private String beanName;

    public BeanCreationException(String message) {
        super(message);
    }

    public BeanCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeanCreationException(String beanName, String message) {
        super("Error creating bean with name '" + beanName + "': " + message);
        this.beanName = beanName;
    }

    public BeanCreationException(String beanName, String message, Throwable cause) {
        this(beanName, message);
        initCause(cause);
    }
}
