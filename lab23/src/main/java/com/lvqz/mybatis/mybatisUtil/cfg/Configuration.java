package com.lvqz.mybatis.mybatisUtil.cfg;

import java.util.Map;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 21:51
 *
 * Mybatis���Զ���������
 *
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String,Mapper> mappers;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);//�˴���Ҫʹ��׷�ӵķ�ʽ
    }
}
