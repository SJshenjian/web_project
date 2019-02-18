package online.shenjian.spring.core.type;

import online.shenjian.spring.core.annotation.AnnotationAttributes;

import java.util.Set;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public interface AnnotationMetadata extends ClassMetadata {

    Set<String> getAnnotationTypes();

    boolean hasAnnotation(String annotationType);

    AnnotationAttributes getAnnotationAttributes(String annotationType);
}
