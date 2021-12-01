package com.wenqi.learn.chapter2.item4;

/**
 * @author Wenqi Liang
 * @date 2021/11/24
 */
public class UtilityClass {
    /**
     * 构造函数私有化, 保证不会被外部调用实例化
     * 抛出异常, 保证该类在任何情况下都不会被实例化
     */
    private UtilityClass() {
        throw new RuntimeException("不能实例化");
    }
}
