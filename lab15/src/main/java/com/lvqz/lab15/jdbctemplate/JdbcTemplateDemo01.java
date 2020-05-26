package com.lvqz.lab15.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author: lvqz
 * @date: 2020/5/20
 * @time: 10:19
 */
public class JdbcTemplateDemo01 {

    public static void main(String [] args){
        //3.准备数据源，spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://");
        ds.setUsername("lvqz");
        ds.setPassword("");



        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        //执行操作
        jt.execute("insert into account(name, money) values ('lalala',1000)");


    }

}
