package com.wenqi.learn.chapter4.item17;

/**
 * Immutable class with static factories instead of constructors
 * <p>
 * 静态工厂实现的不可变类
 *
 * @author liangwenqi
 * @date 2022/1/28
 */
public class ImmutableComplex {
    private final double re;
    private final double im;

    /**
     * 构造函数私有化
     * @param re
     * @param im
     */
    private ImmutableComplex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * 静态方法对外提供对象, 静态工厂的对象具有缓存功能
     *
     * @param re
     * @param im
     * @return
     */
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
}
