package com.lvqz.mybatis.mybatisUtil.session;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 21:41
 */
public interface SqlSession {

    /**
     * ���ݲ�������һ���������
     * @param daoInterfaceClass dao�Ľӿ��ֽ���
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * ����
     */
    void close();

}
