package com.wenqi.learn.chapter4.item20;

/**
 * 骨架类, 可以继承多个接口, 定义模板方法
 *
 * @author liangwenqi
 * @date 2022/2/6
 */
public abstract class AbstractInterface implements AInterface, BInterface {

    @Override
    public abstract Integer a();

    @Override
    public abstract Integer b();

}
