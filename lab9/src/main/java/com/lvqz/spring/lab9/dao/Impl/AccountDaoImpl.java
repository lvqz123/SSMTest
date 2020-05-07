package com.lvqz.spring.lab9.dao.Impl;

import com.lvqz.spring.lab9.dao.IAccountDao;
import com.lvqz.spring.lab9.domain.Account;
import com.lvqz.spring.lab9.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 15:21
 */
public class AccountDaoImpl implements IAccountDao {

    private QueryRunner queryRunner;

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAllAccount() {
        List<Account> query = null;
        try {
            query = queryRunner.query(connectionUtils.getThreadConnection(),"select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public Account findOneAccount(Integer accoutId) {
        Account query = null;
        try {
            query=queryRunner.query(connectionUtils.getThreadConnection(),"select * from account where id = ?",accoutId,new BeanHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    public void insertAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"delete from account where id =?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Account findAccountByName(String accountName) {
        List<Account> querys = null;
        try {
            querys = queryRunner.query(connectionUtils.getThreadConnection(),"select * from account where name = ?",accountName, new BeanListHandler<Account>(Account.class));
            if(querys == null || querys.size() == 0){
                return  null;
            }
            if (querys.size()>1){
                throw new RuntimeException("结果集不唯一，数据有误！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return querys.get(0);
    }
}
