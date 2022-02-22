package com.wenqi.learn.chapter8.item52;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Broken! - What does this program print?
 *
 * @author liangwenqi
 * @date 2022/2/22
 */
public class CollectionClassifier {
    public static String classifier(Set<?> set) {
        return "set";
    }

    public static String classifier(List<?> list) {
        return "list";
    }

    public static String classifier(Collection<?> collection) {
        return "Unknown collection";
    }

    /**
     * 建议使用该方法来替换上面的重载方法
     *
     * @param c
     * @return
     */
    public static String classify(Collection<?> c) {
        return c instanceof Set ? "Set" :c instanceof List ? "List" : "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {new HashSet<String>(), new ArrayList<BigInteger>(), new HashMap<String, String>().values()};
        for (Collection<?> collection : collections) {
            // 这里全部打印了 Unknown collection
            System.out.println(classifier(collection));
        }
    }
}
