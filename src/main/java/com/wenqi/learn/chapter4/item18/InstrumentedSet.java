package com.wenqi.learn.chapter4.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * Wrapper class - uses composition in place of inheritance
 * 包装类, 为子类提供实现
 *
 * 原则: 组合由于继承
 *
 * @author liangwenqi
 * @date 2022/1/29
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
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
