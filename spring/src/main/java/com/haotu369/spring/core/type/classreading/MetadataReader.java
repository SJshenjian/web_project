package com.haotu369.spring.core.type.classreading;

import com.haotu369.spring.core.io.Resource;
import com.haotu369.spring.core.type.AnnotationMetadata;
import com.haotu369.spring.core.type.ClassMetadata;

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
