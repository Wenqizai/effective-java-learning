package com.wenqi.learn.chapter4.item20;

/**
 * @author liangwenqi
 * @date 2022/2/6
 */
public class AbstractDemo extends AbstractInterface {

    @Override
    public Integer a() {
        System.out.println("a...");
        return 1;
    }

    @Override
    public Integer b() {
        System.out.println("b...");
        return 1;
    }

    public static void main(String[] args) {
        AbstractDemo abstractDemo = new AbstractDemo();
        abstractDemo.a();
        abstractDemo.b();
    }
}
