package online.shenjian.spring.v2;

import online.shenjian.dao.AccountDao;
import online.shenjian.service.v2.PetStoreService;
import online.shenjian.spring.context.ApplicationContext;
import online.shenjian.spring.context.support.ClassPathXmlApplicationContext;
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
        assertEquals(2, petStoreService.getVersion());
    }
}
