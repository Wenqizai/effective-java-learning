package com.wenqi.learn.chapter11.item79;

import com.wenqi.learn.chapter4.item18.ForwardingSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liangwenqi
 * @date 2022/3/8
 */
public class ObservableSetGood<E> extends ForwardingSet<E> {

    /**
     * Thread-safe observable set with CopyOnWriteArrayList
     */
    private final List<ObservableSetGood<E>> observers =new CopyOnWriteArrayList<>();

    public ObservableSetGood(Set<E> s) {
        super(s);
    }

    public void addObserver(ObservableSetGood<E> observer) {
        observers.add(observer);
    }

    public boolean removeObserver(ObservableSetGood<E> observer) {
        return observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for (ObservableSetGood<E> observer : observers) {
            //observer.added(this, element);
        }
    }

}
