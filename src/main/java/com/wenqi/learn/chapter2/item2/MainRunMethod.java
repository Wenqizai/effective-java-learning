package com.wenqi.learn.chapter2.item2;

import com.wenqi.learn.chapter2.item1.InterfaceStaticTest;

/**
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public class MainRunMethod {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();();
    }
}
