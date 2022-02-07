package com.wenqi.learn.chapter5.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Chooser - a class badly in need of generics!
 *
 * 选择器 - 一个非常需要泛型的类
 *
 *
 * @author liangwenqi
 * @date 2022/2/7
 */
public class Chooser {
    private final Object[] choiceArray;

    public Chooser(Collection choices) {
        this.choiceArray = choices.toArray();
    }

    /**
     * 每次需要将choose方法的返回值从对象转换为所需的类型，如果类型错误，转换将在运行时失败
     *
     * @return
     */
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
