package com.haotu369.spring.util;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/29
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            classLoader = ClassUtils.class.getClassLoader();
            if (classLoader == null) {
                classLoader = ClassLoader.getSystemClassLoader();
            }
        }
        return classLoader;
    }
}
