package com.wenqi.learn.chapter6.item39;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangwenqi
 * @date 2022/2/14
 */
public class Simple2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() { // Test should pass
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // Should fail (wrong exception)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() { } // Should fail (no exception)

    /**
     * Code containing an annotation with an array parameter
     * 包含带有数组参数的注释的代码
     */
    @ExceptionTest2({ IndexOutOfBoundsException.class,NullPointerException.class })
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        // The spec permits this method to throw either
        // IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }

    /**
     * 重复注解的使用方法
     */
    @ExceptionTest3(IndexOutOfBoundsException.class)
    @ExceptionTest3(NullPointerException.class)
    public static void doublyBad2() {
        List<String> list = new ArrayList<>();
        // The spec permits this method to throw either
        // IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }
}
