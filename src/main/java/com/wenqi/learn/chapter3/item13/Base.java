package com.wenqi.learn.chapter3.item13;

/**
 * x.clone().getClass() != x.getClass()示例
 *
 * 修正: 1. Base中采用super.clone()  2. 移除Base类中整个clone()实现
 * @author liangwenqi
 * @date 2022/1/22
 */
public class Base {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Base();
    }
}

class BasePro extends Base implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        BasePro basePro = new BasePro();
        System.out.println(basePro.clone().getClass()); // class com.wenqi.learn.chapter3.item13.Base
        System.out.println(basePro.getClass());     // class com.wenqi.learn.chapter3.item13.BasePro
    }
}