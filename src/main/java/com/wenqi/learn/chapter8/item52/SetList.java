package com.wenqi.learn.chapter8.item52;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author liangwenqi
 * @date 2022/2/22
 */
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            // list.remove()方法有两个重载：`remove(E)` 和 `remove(int)`
            // 自动装箱和拆箱缘故, Object和index的混淆
            list.remove(i);
        }

        System.out.println(set + "" + list);
    }
}
