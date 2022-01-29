package com.wenqi.learn.chapter4.item19;

import java.time.Instant;

/**
 * @author liangwenqi
 * @date 2022/1/29
 */
public class Sub extends Super {
    /**
     * Blank final, set by constructor
     */
    private final Instant instant;

    public Sub() {
        this.instant = Instant.now();
    }

    /**
     *  Overriding method invoked by superclass constructor
     *  1. 父类构造方法调用了该方法, 父类初始化过程中, 子类还没初始化, 故instant = null
     *  2. 子类初始化完成, instant = 2022-01-29T03:55:04.856Z
     */
    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        // 打印了2次
        // 第一次: null
        // 第二次: 2022-01-29T03:55:04.856Z
        sub.overrideMe();
    }
}
