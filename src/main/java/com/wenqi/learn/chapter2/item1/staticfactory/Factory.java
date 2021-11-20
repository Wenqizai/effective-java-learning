package com.wenqi.learn.chapter2.item1.staticfactory;

/**
 * 基于反射的静态工厂
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public class Factory {

    private Factory() {}

    public static Factory getInstance(String type) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName("com.wenqi.learn.chapter" + type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return factory;
    }
}
