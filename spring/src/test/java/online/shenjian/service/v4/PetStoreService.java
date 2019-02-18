package online.shenjian.service.v4;

import online.shenjian.dao.AccountDao;
import online.shenjian.dao.ItemDao;
import online.shenjian.spring.steretype.Component;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/31
 */
@Component("petStore")
public class PetStoreService {

    private AccountDao accountDao;
    private ItemDao itemDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }
}
