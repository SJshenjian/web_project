package com.haotu369.spring.v4;

import com.haotu369.spring.beans.BeanDefinition;
import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import com.haotu369.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.haotu369.spring.context.annotation.ScannedGenericBeanDefinition;
import com.haotu369.spring.core.annotation.AnnotationAttributes;
import com.haotu369.spring.core.io.ClassPathResource;
import com.haotu369.spring.core.io.Resource;
import com.haotu369.spring.core.type.AnnotationMetadata;
import com.haotu369.spring.steretype.Component;
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