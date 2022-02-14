package com.wenqi.learn.chapter6.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Program to process marker annotations
 * 处理注解的程序
 *
 * @author liangwenqi
 * @date 2022/2/14
 */
public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException {
//        testTest("com.wenqi.learn.chapter6.item39.Sample");

//        testExceptionTest("com.wenqi.learn.chapter6.item39.Simple2");

        testExceptionTest3("com.wenqi.learn.chapter6.item39.Simple2");
    }

    /**
     * 处理注解
     *
     * @param arg
     * @throws ClassNotFoundException
     */
    private static void testTest(String arg) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName(arg);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                    // InvocationTargetException, 它包装了由调用的方法或构造函数抛出的异常。
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    System.out.println(m + " failed: " + exc);
                    // 此异常不是方法调用抛出的异常, 如 : com.wenqi.learn.chapter6.item39.Sample.m5
                } catch (Exception e) {
                    Throwable exc = e.getCause();
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }

    /**
     * 处理指定参数注解
     *
     * @param arg
     * @throws ClassNotFoundException
     */
    private static void testExceptionTest(String arg) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName(arg);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedEx) {
                    // 方法抛出的异常
                    Throwable exc = wrappedEx.getCause();
                    // 注解value里面标注的异常
                    Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();
                    // 注解中的异常是抛出的异常的实例
                    if (excType.isInstance(exc)) {
                        passed++;
                    } else {
                        System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), exc);
                    }
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }

    /**
     * 处理数组参数注解
     *
     * @param arg
     * @throws ClassNotFoundException
     */
    private static void testExceptionTest2(String arg) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName(arg);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest2.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    // 获取注解中的参数数组
                    Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionTest2.class).value();
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("Test %s failed: %s %n", m, exc);
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }

    /**
     * Processing repeatable annotations
     * 处理重复类型的注解
     *
     * @param arg
     * @throws ClassNotFoundException
     */
    private static void testExceptionTest3(String arg) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName(arg);
        for (Method m : testClass.getDeclaredMethods()) {
            // 不能单独使用isAnnotationPresent, 还要判断是否是的容器注解类型
            // 使用一个@ExceptionTest3(), isAnnotationPresent(ExceptionTest3.class) = true, 使用2个以上@ExceptionTest3(), isAnnotationPresent(ExceptionTest3.class) = false && isAnnotationPresent(ExceptionTestContainer.class) = true
            if (m.isAnnotationPresent(ExceptionTest3.class) || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    ExceptionTest3[] excTests = m.getAnnotationsByType(ExceptionTest3.class);
                    for (ExceptionTest3 excTest : excTests) {
                        if (excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("Test %s failed: %s %n", m, exc);
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }


}
