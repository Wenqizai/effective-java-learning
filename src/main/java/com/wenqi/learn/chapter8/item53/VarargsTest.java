package com.wenqi.learn.chapter8.item53;

import java.util.ArrayList;

/**
 * @author liangwenqi
 * @date 2022/2/23
 */
public class VarargsTest {
    /**
     * Simple use of varargs
     * @param args
     * @return
     */
    public static int sum(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    /**
     * 使用可变参来查找最小值
     * The WRONG way to use varargs to pass one or more arguments!
     *
     * @param args
     * @return
     */
    static int min(int... args) {
        // 可变参数可以传多个也可以不传参
        // 假设不传参, 没有length == 0的校验, 直接取args[0]将会在运行时报错(ArrayIndexOutOfBoundsException), 而不是编译时报错
        // 如果加此校验, 又好像违背计算最小值的方法本质
        if (args.length == 0) {
            throw new IllegalArgumentException("Too few arguments");
        }
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    /**
     * The right way to use varargs to pass one or more arguments
     * 正确的可变参数使用, 固定传参firstArg
     *
     * @param firstArg
     * @param remainingArgs
     * @return
     */
    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        //sum(new int[0]);
        min();
    }
}
