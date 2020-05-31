package com.lvqz.mybatis.mybatisUtil.session;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 21:41
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 关流
     */
    void close();

}
