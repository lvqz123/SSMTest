package com.lvqz.mybatis.utils;

import com.lvqz.mybatis.mybatisUtil.cfg.Configuration;
import sun.security.krb5.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 22:37
 */
public class DataSourceUtil {

    /**
     * 用于获取一个连接
     * @return
     */
    public static Connection getConnection(Configuration configuration){

        try {
            Class.forName(configuration.getDriver());
            return DriverManager.getConnection(configuration.getUrl(),configuration.getUsername(),configuration.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
