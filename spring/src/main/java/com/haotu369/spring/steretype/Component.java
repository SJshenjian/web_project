package com.haotu369.spring.steretype;

import java.lang.annotation.*;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/1
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
