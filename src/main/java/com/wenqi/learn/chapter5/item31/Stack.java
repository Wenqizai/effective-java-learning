package com.wenqi.learn.chapter5.item31;

/**
 * @author liangwenqi
 * @date 2022/2/8
 */
public interface Stack<E> {
    public void push(E e);

    public E pop();

    public boolean isEmpty();
}
