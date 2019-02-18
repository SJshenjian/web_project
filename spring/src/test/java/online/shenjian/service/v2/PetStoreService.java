package online.shenjian.service.v2;

import online.shenjian.dao.AccountDao;
import online.shenjian.dao.ItemDao;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/2
 */
public class PetStoreService {

    private AccountDao accountDao;
    private ItemDao itemDao;
    private String author;
    private int version;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
