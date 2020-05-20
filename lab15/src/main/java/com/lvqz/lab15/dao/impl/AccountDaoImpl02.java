package com.lvqz.lab15.dao.impl;

import com.lvqz.lab15.dao.IAccountDao;
import com.lvqz.lab15.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/20
 * @time: 12:03
 */
//@Repository("accountDao02")
public class AccountDaoImpl02 implements IAccountDao {

    //但是此时这些代码，就是赋值JdbcTemplate的代码，如果有多个Dao的实现类，那将会变成重复代码，那么，怎么才能消除重复代码呢？
    //第一种，最简单的一种，使用注解，那么就是每个都Autowired一下
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAllAccount() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findOneAccountById(int id) {
        return jdbcTemplate.query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),id).get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
