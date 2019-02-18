package online.shenjian.spring.v4;

import online.shenjian.spring.beans.BeanDefinition;
import online.shenjian.spring.beans.factory.support.DefaultBeanFactory;
import online.shenjian.spring.beans.factory.xml.XmlBeanDefinitionReader;
import online.shenjian.spring.context.annotation.ScannedGenericBeanDefinition;
import online.shenjian.spring.core.annotation.AnnotationAttributes;
import online.shenjian.spring.core.io.ClassPathResource;
import online.shenjian.spring.core.io.Resource;
import online.shenjian.spring.core.type.AnnotationMetadata;
import online.shenjian.spring.steretype.Component;
import org.junit.Assert;
import org.junit.Test;

public class XmlBeanDefinitionReaderTestV4 {

	@Test
	public void testParseScannedBean(){
		
		DefaultBeanFactory factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		Resource resource = new ClassPathResource("petstore-v4.xml");
		reader.loadBeanDefinitions(resource);
		String annotation = Component.class.getName();

		{
			BeanDefinition bd = factory.getBeanDefinition("petStore");
			Assert.assertTrue(bd instanceof ScannedGenericBeanDefinition);
			ScannedGenericBeanDefinition sbd = (ScannedGenericBeanDefinition)bd;
			AnnotationMetadata amd = sbd.getMetadata();

			Assert.assertTrue(amd.hasAnnotation(annotation));		
			AnnotationAttributes attributes = amd.getAnnotationAttributes(annotation);
			Assert.assertEquals("petStore", attributes.get("value"));
		}
		{
			BeanDefinition bd = factory.getBeanDefinition("accountDao");
			Assert.assertTrue(bd instanceof ScannedGenericBeanDefinition);
			ScannedGenericBeanDefinition sbd = (ScannedGenericBeanDefinition)bd;			
			AnnotationMetadata amd = sbd.getMetadata();
			Assert.assertTrue(amd.hasAnnotation(annotation));
		}
		{
			BeanDefinition bd = factory.getBeanDefinition("itemDao");
			Assert.assertTrue(bd instanceof ScannedGenericBeanDefinition);
			ScannedGenericBeanDefinition sbd = (ScannedGenericBeanDefinition)bd;			
			AnnotationMetadata amd = sbd.getMetadata();
			Assert.assertTrue(amd.hasAnnotation(annotation));
		}
	}

}