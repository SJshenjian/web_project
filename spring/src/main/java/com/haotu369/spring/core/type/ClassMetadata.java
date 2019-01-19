package com.haotu369.spring.core.type;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/1
 */
public interface ClassMetadata {

    String getClassName();

    boolean isInterface();

    boolean isAbstract();

    boolean isFinal();

    boolean hasSuperClass();

    String getSuperClassName();

    String[] getInterfaceNames();
}
