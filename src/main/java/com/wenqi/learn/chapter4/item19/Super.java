package com.wenqi.learn.chapter4.item19;

/**
 * @author liangwenqi
 * @date 2022/1/29
 */
public class Super {
    /**
     * Broken - constructor invokes an overridable method
     * Broken - 构造函数调用了一个可覆盖的方法
     *
     * 子类重写该方法, 将会引发灾难
     *
     * 注意，从构造函数调用私有方法、最终方法和静态方法是安全的，它们都是不可覆盖的。
     */
    public Super() {
        overrideMe();
    }

    public void overrideMe() {

    }
}
