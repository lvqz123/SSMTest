package com.lvqz.spring.lab7.dao.Impl;

import com.lvqz.spring.lab7.dao.IAccountDao;
import com.lvqz.spring.lab7.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 15:21
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner queryRunner;


    public List<Account> findAllAccount() {
        List<Account> query = null;
        try {
            query = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public Account findOneAccount(Integer accoutId) {
        Account query = null;
        try {
            query=queryRunner.query("select * from account where id = ?",accoutId,new BeanHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public void insertAccount(Account account) {
        try {
            queryRunner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            queryRunner.update("delete from account where id =?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
