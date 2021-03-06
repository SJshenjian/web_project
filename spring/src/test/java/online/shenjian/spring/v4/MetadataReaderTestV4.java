package online.shenjian.spring.v4;

import online.shenjian.spring.core.annotation.AnnotationAttributes;
import online.shenjian.spring.core.io.ClassPathResource;
import online.shenjian.spring.core.io.Resource;
import online.shenjian.spring.core.type.AnnotationMetadata;
import online.shenjian.spring.core.type.classreading.MetadataReader;
import online.shenjian.spring.core.type.classreading.SimpleMetadataReader;
import online.shenjian.spring.steretype.Component;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public class MetadataReaderTestV4 {

    @Test
    public void testGetMetadata() throws IOException {
        Resource resource = new ClassPathResource("com/haotu369/service/v4/PetStoreService.class");
        MetadataReader metadataReader = new SimpleMetadataReader(resource);
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        String annotation = Component.class.getName();
        assertTrue(annotationMetadata.hasAnnotation(annotation));
        AnnotationAttributes annotationAttributes = annotationMetadata.getAnnotationAttributes(annotation);
        assertEquals("petStore", annotationAttributes.get("value"));

        Assert.assertFalse(annotationMetadata.isAbstract());
        Assert.assertFalse(annotationMetadata.isFinal());
        Assert.assertEquals("PetStoreService", annotationMetadata.getClassName());
    }
}
