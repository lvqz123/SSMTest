package com.lvqz.spring.lab1.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author: ������
 * @date: 2020/4/27
 * @time: 21:58
 *
 * һ������Bean����Ĺ���
 *
 * Bean���ڼ����Ӣ���У��п���������ĺ���
 *
 * JavaBean:  ��java���Ա�д�Ŀ��������
 *        javabean != ʵ����
 *        javabean >  ʵ����
 *
 * �����Ǵ������ǵ�service��dao�����
 *
 * ��һ������Ҫһ�������ļ��������ǵ�service��dao
 * �ڶ�����ͨ����ȡ�����ļ������õ����ݣ����䴴������
 *
 */
public class BeanFactory {

    //����һ��Properties����
    private static Properties props;
    private static Map<String,Object> beans;

    //ʹ�þ�̬�������ΪProperties����ֵ
    static {
        try {
            //ʵ��������
            props = new Properties();
            //��ȡProperties�ļ���������
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beanFactory.properties");
            props.load(in);

            //ͨ����̬�����ʵ�ֵ�������̬�����ֻ���������֮��ִ��һ�Σ�
            //ʵ��������
            beans = new HashMap<String, Object>();
            //ȡ�������ļ������е�key
            Enumeration<Object> keys = props.keys();
            //����ö��
            while (keys.hasMoreElements()){
                //ȡ��ÿ��key
                String key = keys.nextElement().toString();
                System.out.println(key);
//                System.out.println(props.get(key));
                //���䴴������
                Object value = Class.forName(props.getProperty(key)).newInstance();
                beans.put(key,value);
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("��ʼ��propertiesʧ�ܣ�");
        }
    }


    //����ģʽ��ֱ����ȡ�����õ�Map�����еĶ���
    public static Object getBean(String beanName){
        return beans.get(beanName);

    }

   /*
    ����ģʽ��Ч�ʲ�����
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            bean =Class.forName(props.getProperty(beanName)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;

    }*/





}
