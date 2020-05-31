package com.lvqz.mybatis.mybatisUtil.io;

import java.io.InputStream;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 21:31
 *
 * 使用类加载器读取配置文件的类
 *
 */
public class Resources {
    /**
     * 根据传入的参数，加载对应配置文件
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
