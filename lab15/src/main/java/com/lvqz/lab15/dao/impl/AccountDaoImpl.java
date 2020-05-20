package com.lvqz.lab15.dao.impl;

import com.lvqz.lab15.dao.IAccountDao;
import com.lvqz.lab15.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/20
 * @time: 12:03
 */
@SuppressWarnings("all")
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    //但是此时这些代码，就是赋值JdbcTemplate的代码，如果有多个Dao的实现类，那将会变成重复代码，那么，怎么才能消除重复代码呢？
    //第一种，使用注解Autowired，看AccountDaoImpl02案例
    //第二种，抽取重复代码做抽象，继承重复代码类,具体注释看jdbcDaoSupport类。
    //但是，这样显得很麻烦，而我们都能想到这种重构，那Spring能想不到吗？ 重新extendsJdbcDaoSupport，将包改成Spring的

    public List<Account> findAllAccount() {
        return super.getJdbcTemplate().query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findOneAccountById(int id) {
        return super.getJdbcTemplate().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),id).get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }
}
