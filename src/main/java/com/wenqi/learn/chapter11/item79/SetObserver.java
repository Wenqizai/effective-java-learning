package com.wenqi.learn.chapter11.item79;

/**
 * @author liangwenqi
 * @date 2022/3/8
 */
@FunctionalInterface
public interface SetObserver<E> {
    /**
     * Invoked when an element is added to the observable set
     * 将元素添加到可观察集时调用
     *
     * @param set
     * @param element
     */
    void added(ObservableSet<E> set, E element);
}
