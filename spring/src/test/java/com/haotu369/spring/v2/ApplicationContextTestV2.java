package com.haotu369.spring.v2;

import com.haotu369.dao.v2.AccountDao;
import com.haotu369.service.v2.PetStoreService;
import com.haotu369.spring.context.ApplicationContext;
import com.haotu369.spring.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/2
 */
public class ApplicationContextTestV2 {

    @Test
    public void testGetBeanProperty() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("petstore-v2.xml");
        PetStoreService petStoreService = (PetStoreService) applicationContext.getBean("petStoreService");
        assertNotNull(petStoreService.getAccountDao());
        assertNotNull(petStoreService.getItemDao());

        assertTrue(petStoreService.getAccountDao() instanceof AccountDao);
        assertEquals("Jian Shen", petStoreService.getAuthor());
    }
}
