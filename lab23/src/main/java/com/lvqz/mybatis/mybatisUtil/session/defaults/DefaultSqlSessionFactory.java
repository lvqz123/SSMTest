package com.lvqz.mybatis.mybatisUtil.session.defaults;

import com.lvqz.mybatis.mybatisUtil.cfg.Configuration;
import com.lvqz.mybatis.mybatisUtil.session.SqlSession;
import com.lvqz.mybatis.mybatisUtil.session.SqlSessionFactory;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 22:15
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
