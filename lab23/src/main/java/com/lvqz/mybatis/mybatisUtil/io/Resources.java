package com.lvqz.mybatis.mybatisUtil.io;

import java.io.InputStream;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 21:31
 *
 * ʹ�����������ȡ�����ļ�����
 *
 */
public class Resources {
    /**
     * ���ݴ���Ĳ��������ض�Ӧ�����ļ�
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
