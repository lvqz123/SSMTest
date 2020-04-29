package com.lvqz.spring.lab5.dao.impl;

import com.lvqz.spring.lab5.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author: lvqz
 * @date: 2020/4/27
 * @time: 21:51
 */
@Repository
public class AccountDaoImpl2 implements IAccountDao {

    //保存用户的方法
    public void saveAccount() {
        System.out.println("保存用户2222！");

    }
}
