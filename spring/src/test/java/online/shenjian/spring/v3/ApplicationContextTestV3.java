package online.shenjian.spring.v3;

import online.shenjian.dao.AccountDao;
import online.shenjian.service.v3.PetStoreService;
import online.shenjian.spring.context.ApplicationContext;
import online.shenjian.spring.context.support.ClassPathXmlApplicationContext;
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
