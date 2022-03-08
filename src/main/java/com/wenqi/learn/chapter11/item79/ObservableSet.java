package com.wenqi.learn.chapter11.item79;

import com.wenqi.learn.chapter4.item18.ForwardingSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Broken - invokes alien method from synchronized block!
 *
 * Broken - 从同步块调用外部方法！
 *
 * @author liangwenqi
 * @date 2022/3/8
 */
public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers= new ArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized(observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized(observers) {
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
        synchronized(observers) {
            for (SetObserver<E> observer : observers) {
                observer.added(this, element);
            }
        }
    }


    /**
     * Alien method moved outside of synchronized block - open calls
     * @param element
     */
    private void notifyElementAddedGood(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized(observers) {
            snapshot = new ArrayList<>(observers);
        }
        for (SetObserver<E> observer :snapshot) {
            observer.added(this, element);
        }
    }


    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementAdded(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            // Calls notifyElementAdded
            result |= add(element);
        }
        return result;
    }

    public static void main(String[] args) {
        ObservableSet<Integer> set =new ObservableSet<>(new HashSet<>());
        // Observer that uses a background thread needlessly
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> s.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    private static void test2() {
        ObservableSet<Integer> set =new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                // java.util.ConcurrentModificationException
                if (e == 23) {
                    s.removeObserver(this);
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

    private static void test1() {
        ObservableSet<Integer> set =new ObservableSet<>(new HashSet<>());
        set.addObserver((s, e) -> System.out.println(e));
        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

}
