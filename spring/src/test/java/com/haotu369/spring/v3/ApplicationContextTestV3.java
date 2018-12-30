package com.haotu369.spring.v3;

import com.haotu369.dao.AccountDao;
import com.haotu369.service.v3.PetStoreService;
import com.haotu369.spring.context.ApplicationContext;
import com.haotu369.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/9
 */
public class ApplicationContextTestV3 {

    @Test
    public void testGetBeanProperty() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("petstore-v3.xml");
        PetStoreService petStoreServiceOne = (PetStoreService) applicationContext.getBean("petStoreServiceOne");
        assertNotNull(petStoreServiceOne.getAccountDao());
        assertNotNull(petStoreServiceOne.getItemDao());

        assertTrue(petStoreServiceOne.getAccountDao() instanceof AccountDao);
        assertEquals(2, petStoreServiceOne.getVersion());
        assertEquals(null, petStoreServiceOne.getAuthor());
    }
}
