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
 * ���ڴ���һ��SqlSessionFactory����
 *
 */
public class SqlSessionFactoryBuilder {

    /**
     * ���ݲ������ֽ�������������һ��SqlSessionFactory����
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration configuration = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(configuration);
    }

}
