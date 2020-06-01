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
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在的类名
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className +"." +methodName;
        //4.获取mappers中的mapper
        Mapper mapper = mappers.get(key);
        //5.判断mapper是否存在
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //调用工具类执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
