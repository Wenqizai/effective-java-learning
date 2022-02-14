package com.wenqi.learn.chapter6.item38;

/**
 * Emulated extensible enum using an interface
 * 使用接口模拟可扩展枚举
 *
 * @author liangwenqi
 * @date 2022/2/14
 */
public interface Operation {
    double apply(double x, double y);
}
