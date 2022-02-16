package com.wenqi.learn.chapter6.item39;

import java.lang.reflect.Method;

/**
 * @author Wenqi Liang
 * @date 2022/2/14
 */
public class Simple4 {
    /**
     * Code containing a repeated annotation
     * 包含重复注解的代码
     */
    @ExceptionTest3(IndexOutOfBoundsException.class)
    @ExceptionTest3(NullPointerException.class)
    public static void doublyBad() {
    }

    @ExceptionTest3(ArithmeticException.class)
    public static void doublyBad2() {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> testClass = Simple4.class;
        for (int count = 1; count <= 2; count++) {
            Method m = testClass.getMethod(count == 1 ? "doublyBad" : "doublyBad" + count);
            System.out.println(m.getName() + "「重复状态」：" + m.isAnnotationPresent(ExceptionTest3.class));
            System.out.println(m.getName() + "「容器注解类型」：" + m.isAnnotationPresent(ExceptionTestContainer.class));
            System.out.println(m.getName() + "「非重复状态」：" + m.isAnnotationPresent(ExceptionTest3.class));
            System.out.println(m.getName() + "「重复状态」：" + m.getAnnotationsByType(ExceptionTest3.class));
            System.out.println(m.getName() + "「容器注解类型」：" + m.getAnnotationsByType(ExceptionTestContainer.class));
            System.out.println(m.getName() + "「非重复状态」：" + m.getAnnotationsByType(ExceptionTest3.class));
        }
    }
}
