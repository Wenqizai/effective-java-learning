package com.wenqi.learn.chapter3.item13;

import java.util.Map.Entry;

/**
 * @author liangwenqi
 * @date 2022/1/22
 */
public class HashTable implements Cloneable {
    private Entry[] buckets = new Entry[1024];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        HashTable result = (HashTable) super.clone();
        result.buckets = buckets.clone();
        return result;
    }
}
