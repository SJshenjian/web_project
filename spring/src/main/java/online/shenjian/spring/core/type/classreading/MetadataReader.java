package online.shenjian.spring.core.type.classreading;

import online.shenjian.spring.core.io.Resource;
import online.shenjian.spring.core.type.AnnotationMetadata;
import online.shenjian.spring.core.type.ClassMetadata;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public interface MetadataReader {

    Resource getResource();

    ClassMetadata getClassMetadata();

    AnnotationMetadata getAnnotationMetadata();
}
