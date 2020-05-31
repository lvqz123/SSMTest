package com.lvqz.mybatis.mybatisUtil.session.defaults;

import com.lvqz.mybatis.mybatisUtil.cfg.Configuration;
import com.lvqz.mybatis.mybatisUtil.cfg.Mapper;
import com.lvqz.mybatis.mybatisUtil.session.SqlSession;
import com.lvqz.mybatis.mybatisUtil.session.proxy.MapperProxy;
import com.lvqz.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 22:18
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        connection = DataSourceUtil.getConnection(configuration);
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass.getClass()}, new MapperProxy(configuration.getMappers(), connection));

    }

    public void close() {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
