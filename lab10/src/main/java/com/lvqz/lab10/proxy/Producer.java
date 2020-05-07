package com.lvqz.lab10.proxy;

/**
 * @author: lvqz
 * @date: 2020/5/7
 * @time: 11:39
 *
 * 创建一个生产者，模拟厂家
 *
 */
public class Producer implements IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduce(float money){
        System.out.println("销售产品，并拿到钱：" + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱" + money);
    }

}
