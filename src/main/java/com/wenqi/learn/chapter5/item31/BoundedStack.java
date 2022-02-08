package com.wenqi.learn.chapter5.item31;

import java.util.Collection;

/**
 * @author liangwenqi
 * @date 2022/2/8
 */
public class BoundedStack<E> implements Stack<E> {

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * 生产者使用extends
     * @param src
     */
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    /**
     * 消费者使用super
     * @param dst
     */
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
}
