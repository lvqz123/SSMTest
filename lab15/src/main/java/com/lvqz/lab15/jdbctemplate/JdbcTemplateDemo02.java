package com.lvqz.lab15.jdbctemplate;

import com.lvqz.lab15.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/20
 * @time: 10:19
 */
public class JdbcTemplateDemo02 {

    public static void main(String [] args){
       //1.创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.创建jdbcTemplate的bean对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //执行操作
//        jt.execute("insert into account(name, money) values ('lalala',1000)");
        //保存
//        jt.update("insert into account(name, money) values (?,?)","eee",1234);
        //更新
//        jt.update("update account set name =?,money = ? where id = ?","test",5201,9);
        //删除
//        jt.update("delete from account where id = ?",9);
        //查询所有
//        List<Account> accounts = jt.query("select * from account where money > ?", new AccountRowMapper(), 1000f);
//        使用Spring已经封装好的BeanPropertyRowMapper<T>
//        List<Account> accounts = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        //查询一个
        List<Account> accounts = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 8);
        System.out.println(accounts.isEmpty()?"没有数据":accounts.get(0));
        //查询返回一行一列(需要什么类型参数里面就写什么类型的字节码)
        Integer count = jt.queryForObject("select count(*) from account where money > ?", Integer.class, 1000f);
        System.out.println(count);
    }
}
class AccountRowMapper implements RowMapper<Account>{
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}