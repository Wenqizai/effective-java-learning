package com.wenqi.learn.chapter3.item13;

/**
 * x.clone().getClass() != x.getClass()示例
 *
 * 修正: 1. Base中采用super.clone()  2. 移除Base类中整个clone()实现
 * @author liangwenqi
 * @date 2022/1/22
 */
public class Base {
    /**
     * 通过构造器实现, 子类调用super.clone()就会出现 x.clone().getClass() != x.getClass() 的行为
     * 修复: 1. 移除clone()方法  2. new Base() 替换成 super.clone()
     *
     * @return
     * @throws CloneNotSupportedException
     */
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