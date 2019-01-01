package com.haotu369.spring.v4;

import com.haotu369.service.v4.PetStoreService;
import com.haotu369.spring.context.ApplicationContext;
import com.haotu369.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/31
 */
public class ApplicationContextTestV4 {

    @Test
    public void testGetBeanProperty() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("petstore-v4.xml");

        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStoreService");
        Assert.assertNotNull(petStoreService);
    }
}
