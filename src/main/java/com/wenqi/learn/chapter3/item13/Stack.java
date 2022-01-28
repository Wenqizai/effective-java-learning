package com.wenqi.learn.chapter3.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author liangwenqi
 * @date 2022/1/22
 */
public class Stack {
    protected Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    /**
     * Ensure space for at least one more element.
     * 确保至少再有一个元素的空间
     *
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    /**
     * 如果没有实现clone()方法, 子类调用super.clone(), 此时子类只会复制elements的引用
     * 子类和父类公用同一个elements数组将会引发灾难, 各种空指针
     *
     * 解决: 父类实现clone()方法, 并调用elements.clone(), 产生elements副本供子类使用
     *
     * @return
     */
    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
