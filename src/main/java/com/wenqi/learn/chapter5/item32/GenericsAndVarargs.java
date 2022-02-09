package com.wenqi.learn.chapter5.item32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 泛型与可变参数
 *
 * @author liangwenqi
 * @date 2022/2/9
 */
public class GenericsAndVarargs {
    /**
     * Mixing generics and varargs can violate type safety!
     * 泛型和可变参数混合使用可能违反类型安全原则！
     *
     * @param stringLists
     */
    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = Collections.singletonList(42);
        Object[] objects = stringLists;
        // Heap pollution
        objects[0] = intList;
        // ClassCastException
        String s = stringLists[0].get(0);
    }

    /**
     * Safe method with a generic varargs parameter
     *
     * 具有通用可变参数的安全方法
     *
     * @param lists
     * @param <T>
     * @return
     */
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        // Can't get here
        throw new AssertionError();
    }

    /**
     * 避免使用可变参数
     * @param a
     * @param b
     * @param c
     * @param <T>
     * @return
     */
    static <T> List<T> pickTwoGood(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return Arrays.asList(a, b);
            case 1: return Arrays.asList(a, c);
            case 2: return Arrays.asList(b, c);
        }
        throw new AssertionError();
    }

    /**
     * UNSAFE - Exposes a reference to its generic parameter array!
     * 不安全 - 公开对其通用参数数组的引用！
     * @param args
     * @param <T>
     * @return
     */
    static <T> T[] toArray(T... args) {
        return args;
    }

    /**
     * List as a typesafe alternative to a generic varargs parameter
     * 列出作为泛型可变参数参数的类型安全替代方案
     *
     * @param lists
     * @param <T>
     * @return
     */
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

}
