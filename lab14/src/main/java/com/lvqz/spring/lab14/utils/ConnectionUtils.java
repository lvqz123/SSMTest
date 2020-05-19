package com.lvqz.spring.lab14.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author: 吕秋圳
 * @date: 2020/5/3
 * @time: 12:13
 */
@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    public Connection getThreadConnection(){
        Connection conn = null;
        try {
            //1.先从ThreadLocal上获取
            conn = tl.get();
            //2.判断当前线程是否有连接
            if (conn == null){
                //3.从数据源中获取一个连接，并且存入ThreadLocal
                conn = dataSource.getConnection();
                tl.set(conn);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //返回当前线程的连接
        return conn;
    }


    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }

}
