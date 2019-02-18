package online.shenjian.spring.beans.factory;

import online.shenjian.spring.beans.BeansException;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/29
 */
public class BeanDefinitionStoreException extends BeansException {

    public BeanDefinitionStoreException(String message) {
        super(message);
    }

    public BeanDefinitionStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
