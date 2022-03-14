package com.wenqi.learn.chapter12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liangwenqi
 * @date 2022/3/10
 */
public class Item85 {

    public static void main(String[] args) {
        bomb();
    }

    /**
     * Deserialization bomb - deserializing this stream takes forever
     * @return
     */
    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            // Make t1 unequal to t2
            t1.add("foo");
            s1.add(t1); s1.add(t2);
            s2.add(t1); s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        //return serialize(root); // Method omitted for brevity
        return null;
    }
}
