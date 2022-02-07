package com.wenqi.learn.chapter5.item28;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liangwenqi
 * @date 2022/2/7
 */
public class ListArray {
    public static void main(String[] args) {
        //test1();
        test4();
    }

    // List由于数组, 数组放入不相容的类型可以编译成功, 运行时失败
    // List放入不相容的类型时, 编译失败


    public static void test1() {
        // Fails at runtime!
        Object[] objArray = new Long[1];
        // Throws ArrayStoreException
        objArray[0] = "I don't fit in";
    }

    public static void test2() {
        // Won't compile!
        // Incompatible types
        //List<Object> ol = new ArrayList<Long>();
        //ol.add("I don't fit in");
    }

    /**
     * Why generic array creation is illegal - won't compile!
     *
     * 为什么泛型数组创建是非法的 - 不会编译！
     */
    public static void test3() {
        //// 由下推断, 创建泛型数组是非法的
        //List<String>[] stringLists = new List<String>[1];
        //
        //List<Integer> intList = List.of(42);
        //
        //// Object[]为String类型
        //Object[] objects = stringLists;
        //
        //// Object[]放入Integer类型的List(可以放入, 因为类型擦除)
        //objects[0] = intList;
        //
        //// 报ClassCastException, 从String中取到Integer, 并将Integer强转成String
        //String s = stringLists[0].get(0);
    }

    public static void test4() {
        String[] objects = new String[1];

        // 编译通过, 此时objs为String类型
        Object[] objs = objects;

        Integer[] intObj = new Integer[1];

        // 编译报错
        //intObj = objs;

        objs[0] = "1";
        objs[0] = 1;
    }


}
