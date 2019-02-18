package online.shenjian.spring.v4;

import online.shenjian.spring.beans.BeanDefinition;
import online.shenjian.spring.beans.factory.support.DefaultBeanFactory;
import online.shenjian.spring.context.annotation.ClassPathBeanDefinitionScanner;
import online.shenjian.spring.context.annotation.ScannedGenericBeanDefinition;
import online.shenjian.spring.core.type.AnnotationMetadata;
import online.shenjian.spring.steretype.Component;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2019/1/19
 */
public class ClassPathBeanDefinitionScannerTestV4 {

    @Test
    public void testParseScannedBean () {
        DefaultBeanFactory factory = new DefaultBeanFactory();
        String basePackage = "com.haotu369.service.v4,com.haotu369.dao";
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(factory);
        scanner.doScan(basePackage);

        String annotation = Component.class.getName();

        {
            BeanDefinition definition = factory.getBeanDefinition("petStore");
            assertTrue(definition instanceof ScannedGenericBeanDefinition);
            ScannedGenericBeanDefinition scannedGenericBeanDefinition = (ScannedGenericBeanDefinition) definition;
            AnnotationMetadata metadata = scannedGenericBeanDefinition.getMetadata();
            assertTrue(metadata.hasAnnotation(annotation));
        }
        {
            BeanDefinition definition = factory.getBeanDefinition("accountDao");
            assertTrue(definition instanceof ScannedGenericBeanDefinition);
            ScannedGenericBeanDefinition scannedGenericBeanDefinition = (ScannedGenericBeanDefinition) definition;
            AnnotationMetadata metadata = scannedGenericBeanDefinition.getMetadata();
            assertTrue(metadata.hasAnnotation(annotation));
        }
        {
            BeanDefinition definition = factory.getBeanDefinition("itemDao");
            assertTrue(definition instanceof ScannedGenericBeanDefinition);
            ScannedGenericBeanDefinition scannedGenericBeanDefinition = (ScannedGenericBeanDefinition) definition;
            AnnotationMetadata metadata = scannedGenericBeanDefinition.getMetadata();
            assertTrue(metadata.hasAnnotation(annotation));

        }
    }
}
