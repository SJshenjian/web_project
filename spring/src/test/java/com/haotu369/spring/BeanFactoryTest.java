package com.haotu369.spring;

import com.haotu369.service.PetStoreService;
import com.haotu369.spring.beans.BeansDefinition;
import com.haotu369.spring.beans.factory.BeanFactory;
import com.haotu369.spring.beans.factory.support.BeanCreationException;
import com.haotu369.spring.beans.factory.support.BeanDefinitionStoreException;
import com.haotu369.spring.beans.factory.support.DefaultBeanFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/10/28
 */
public class BeanFactoryTest {

    @Test
    public void testBeanFactory() {
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");

        BeansDefinition definition = factory.getBeanDefinition("petStore");
        String className = definition.getBeanClassName();

        assertEquals("com.haotu369.service.PetStoreService", className);

        PetStoreService petStoreService = (PetStoreService) factory.getBean("petStore");
        assertNotNull(petStoreService);
    }

    @Test(expected = BeanCreationException.class)
    public void testInvalidBean(){
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        factory.getBean("invalid");
    }

    @Test(expected = BeanDefinitionStoreException.class)
    public void testInvalidXml() {
        new DefaultBeanFactory("invalid.xml");
    }
}
