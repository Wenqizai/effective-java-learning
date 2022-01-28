package com.wenqi.learn.chapter3.item13;

/**
 * Recursive clone method for class with complex mutable state
 * 具有复杂可变状态的类的递归克隆方法
 * <p>
 * 深拷贝
 *
 * @author liangwenqi
 * @date 2022/1/28
 */
public class HashTableDeepCopy {
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

        /**
         * Recursively copy the linked list headed by this Entry
         * 递归复制以该Entry为首的链表
         *
         * 注意: 递归遍历链表中的每个元素消耗一个堆栈帧, 长链表容易引发栈溢出
         *
         * @return
         */
        Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }

        /**
         * 迭代遍历: 不易栈溢出
         *
         * @return
         */
        Entry deepCopy2() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    @Override
    protected HashTableDeepCopy clone() throws CloneNotSupportedException {
        try {
            HashTableDeepCopy result = (HashTableDeepCopy) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                }

            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
