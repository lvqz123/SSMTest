package com.lvqz.lab10.proxy;

/**
 * @author: lvqz
 * @date: 2020/5/7
 * @time: 11:42
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduce(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);

}
