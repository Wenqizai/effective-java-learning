package com.wenqi.learn.chapter5.item30;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liangwenqi
 * @date 2022/2/7
 */
public class GenericMethod {

    /**
     * Uses raw types - unacceptable! (Item 26)
     * @param s1
     * @param s2
     * @return
     */
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * Generic method
     * @param s1
     * @param s2
     * @param <E>
     * @return
     */
    public static <E> Set<E> unionGeneric(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

}
