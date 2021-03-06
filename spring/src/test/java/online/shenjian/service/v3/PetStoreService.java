package online.shenjian.service.v3;

import online.shenjian.dao.AccountDao;
import online.shenjian.dao.ItemDao;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/9
 */
public class PetStoreService {

    private AccountDao accountDao;
    private ItemDao itemDao;
    private String author;
    private int version;

    public PetStoreService() {

    }

    public PetStoreService(AccountDao accountDao, ItemDao itemDao) {
        this.accountDao = accountDao;
        this.itemDao = itemDao;
    }

    public PetStoreService(AccountDao accountDao, ItemDao itemDao, int version) {
        this.accountDao = accountDao;
        this.itemDao = itemDao;
        this.version = version;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public int getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }
}
