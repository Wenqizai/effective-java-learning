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

    /**
     * Broken clone method - results in shared mutable state!
     * 损坏的克隆方法 - 导致共享可变状态
     *
     * 该clone()虽然clone了buckets, 但是buckets内部维系的是一个Entry组成的链表,
     * 即使clone了buckets, 但是buckets内部维系的链表引用不变, 也会引发灾难性行为
     *
     * @return
     */
    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = buckets.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
