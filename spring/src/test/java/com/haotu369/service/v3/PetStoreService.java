package com.haotu369.service.v3;

import com.haotu369.dao.v2.AccountDao;
import com.haotu369.dao.v2.ItemDao;

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

    // TODO 最佳匹配
    public PetStoreService(AccountDao accountDao, ItemDao itemDao, String author) {
        this.accountDao = accountDao;
        this.itemDao = itemDao;
        this.author = author;
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
