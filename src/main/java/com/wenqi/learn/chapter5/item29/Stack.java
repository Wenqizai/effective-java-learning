package com.wenqi.learn.chapter5.item29;

import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Initial attempt to generify Stack - won't compile!
 *
 * 最初尝试生成 Stack - 无法编译！
 *
 * @author liangwenqi
 * @date 2022/2/7
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        // 类型参数“E”不能直接实例化, 不能编译
        //elements = new E[DEFAULT_INITIAL_CAPACITY];

        // 强转
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
