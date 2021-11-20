package com.wenqi.learn.chapter2.item1;

/**
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public interface InterfaceStaticTest {
    /**
     * 在 JDK 8 之前，接口不能有静态方法
     * JDK8正常运行, JDK7 报错:
     *      java: System Java Compiler was not found in classpath:
     *      java.lang.ClassNotFoundException: com.sun.tools.javac.api.JavacTool
     */
    public static void allowforjdk8() {
        System.out.println("可以运行不?");
    }
}
