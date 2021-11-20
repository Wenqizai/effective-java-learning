package com.wenqi.learn.chapter2.item1.staticfactory;

/**
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public class SingletonClass {

    private static volatile SingletonClass instance = null;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
