package com.wenqi.learn.chapter7.item42;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

/**
 * @author liangwenqi
 * @date 2022/2/16
 */
public class LambdaDemo {

    public void demo(List<String> words) {
        // Anonymous class instance as a function object - obsolete!
        // 已过时
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // Lambda expression as function object (replaces anonymous class)
        // Lambda 表达式作为函数对象（替换匿名类）
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));


        // 使用 comparator 构造方法代替 lambda 表达式，那么代码片段可以变得更加简洁：
        Collections.sort(words, comparingInt(String::length));

        // 适用List.sort()方法
        words.sort(comparingInt(String::length));

    }


}
