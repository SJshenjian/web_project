package com.haotu369.service.v4;

import com.haotu369.dao.AccountDao;
import com.haotu369.dao.ItemDao;
import com.haotu369.spring.steretype.Component;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/12/31
 */
@Component(value = "petStore")
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
