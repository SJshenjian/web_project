package com.haotu369.spring.v4;

import com.haotu369.spring.core.annotation.AnnotationAttributes;
import com.haotu369.spring.core.io.ClassPathResource;
import com.haotu369.spring.core.io.Resource;
import com.haotu369.spring.core.type.classreading.AnnotationMetadataReadingVisitor;
import com.haotu369.spring.core.type.classreading.ClassMetadataReadingVisitor;
import org.junit.Test;
import org.springframework.asm.ClassReader;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/1
 */
public class ClassReaderTestV4 {

    @Test
    public void testGetClassMetadata() throws IOException {
        Resource resource = new ClassPathResource("com/haotu369/service/v4/PetStoreService.class");
        ClassReader reader = new ClassReader(resource.getInputStream());
        ClassMetadataReadingVisitor visitor = new ClassMetadataReadingVisitor();

        reader.accept(visitor, ClassReader.SKIP_DEBUG);

        assertFalse(visitor.isAbstract());
        assertFalse(visitor.isInterface());
        assertFalse(visitor.isFinal());

        assertTrue(visitor.hasSuperClass());
        assertEquals("com.haotu369.service.v4.PetStoreService", visitor.getClassName());
        assertEquals("java.lang.Object", visitor.getSuperClassName());
        assertEquals(0, visitor.getInterfaceNames().length);
    }

    @Test
    public void testGetAnnotation() throws IOException {
        Resource resource = new ClassPathResource("com/haotu369/service/v4/PetStoreService.class");
        ClassReader reader = new ClassReader(resource.getInputStream());
        AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor();
        reader.accept(visitor, ClassReader.SKIP_DEBUG);

        String annotation = "com.haotu369.spring.steretype.Component";
        assertTrue(visitor.hasAnnotation(annotation));

        AnnotationAttributes attributes = visitor.getAnnotationAttributes(annotation);
        assertEquals("petStore", attributes.get("value"));
    }
}
