package com.haotu369.service.v2;

import com.haotu369.dao.v2.AccountDao;
import com.haotu369.dao.v2.ItemDao;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/2
 */
public class PetStoreService {

    private AccountDao accountDao;
    private ItemDao itemDao;

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
}
