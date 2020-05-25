package com.lvqz.lab15.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author: lvqz
 * @date: 2020/5/20
 * @time: 15:43
 *
 * 手撕JdbcDaoSupport源码
 *
 */
public class JdbcDaoSupport {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() { return jdbcTemplate;}

    //那么可以在重复代码中放JdbcTemplate，那么可不可以放一个DataSource？
    //这样的话，由于DaoImpl继承了此类，那么相当于DaoImpl中也有了setDataSource方法，那么bean中就不再往Dao中注入JdbcTemplate，直接注入这个setDataSource就相当于有了jdbcTemplate
    public void setDataSource(DataSource dataSource){
        if (jdbcTemplate == null){
            jdbcTemplate = createJdbcTemplate(dataSource);
        }
    }

    private JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
