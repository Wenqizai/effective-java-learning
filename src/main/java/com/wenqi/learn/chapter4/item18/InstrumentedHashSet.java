package com.wenqi.learn.chapter4.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Broken - Inappropriate use of inheritance!
 * 不适当地使用继承
 *
 * @author liangwenqi
 * @date 2022/1/28
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    /**
     * The number of attempted element insertions
     * 尝试插入元素的次数
     */
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        // addAll(c)方法实际是每次调用add()方法, 导致addCount被重复计数, 输出是6, 不是3
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        // 输出6, 不是3
        System.out.println(s.getAddCount());
    }
}
