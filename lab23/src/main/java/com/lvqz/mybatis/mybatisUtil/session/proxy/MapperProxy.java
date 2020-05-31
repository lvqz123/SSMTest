package com.lvqz.mybatis.mybatisUtil.session.proxy;

import com.lvqz.mybatis.mybatisUtil.cfg.Mapper;
import com.lvqz.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 22:22
 */
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers,Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //��ȡ������
        String methodName = method.getName();
        //��ȡ�������ڵ�����
        String className = method.getDeclaringClass().getName();
        //3.���key
        String key = className +"." +methodName;
        //��ȡmappers�е�mapper
        Mapper mapper = mappers.get(key);
        //�ж�mapper�Ƿ����
        if(mapper == null){
            throw new IllegalArgumentException("����Ĳ�������");
        }
        //���ù�����ִ�в�ѯ����
        return new Executor().selectList(mapper,conn);
    }
}
