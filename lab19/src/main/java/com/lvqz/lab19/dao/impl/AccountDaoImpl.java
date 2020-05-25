package com.lvqz.lab19.dao.impl;

import com.lvqz.lab19.dao.IAccountDao;
import com.lvqz.lab19.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/20
 * @time: 12:03
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    public List<Account> findAllAccount() {
        return super.getJdbcTemplate().query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }


    public Account findAccountById(Integer accountId) {
        return super.getJdbcTemplate().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId).get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts.isEmpty()){
            return null;
        }
        if (accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }

        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
