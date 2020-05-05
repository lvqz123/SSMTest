package com.lvqz.spring.lab9.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: ������
 * @date: 2020/5/3
 * @time: 12:13
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){
        Connection conn = null;
        try {
            //1.�ȴ�ThreadLocal�ϻ�ȡ
            conn = tl.get();
            //2.�жϵ�ǰ�߳��Ƿ�������
            if (conn == null){
                //3.������Դ�л�ȡһ�����ӣ����Ҵ���ThreadLocal
                conn = dataSource.getConnection();
                tl.set(conn);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //���ص�ǰ�̵߳�����
        return conn;
    }


    /**
     * �����Ӻ��߳̽��
     */
    public void removeConnection(){
        tl.remove();
    }

}
