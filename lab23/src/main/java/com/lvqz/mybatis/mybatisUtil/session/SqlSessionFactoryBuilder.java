package com.lvqz.mybatis.mybatisUtil.session;

import com.lvqz.mybatis.mybatisUtil.cfg.Configuration;
import com.lvqz.mybatis.mybatisUtil.session.defaults.DefaultSqlSessionFactory;
import com.lvqz.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 21:35
 *
 * 用于创建一个SqlSessionFactory对象
 *
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(configuration);
    }

}
