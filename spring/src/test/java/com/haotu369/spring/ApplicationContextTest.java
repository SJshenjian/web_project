package com.haotu369.spring;

import com.haotu369.service.PetStoreService;
import com.haotu369.spring.context.ApplicationContext;
import com.haotu369.spring.context.support.ClassPathXmlApplicationContext;
import com.haotu369.spring.context.support.FileSystemXmlApplicationContext;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/11
 */
public class ApplicationContextTest {

    @Test
    public void testClassPathXmlApplicationContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStore");
        assertNotNull(petStoreService);
    }

    @Test
    public void testFileSystemXmlApplicationContext() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src\\" +
        "main\\resources\\petstore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStore");
        assertNotNull(petStoreService);
    }
}
