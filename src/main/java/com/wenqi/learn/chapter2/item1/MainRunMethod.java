package com.wenqi.learn.chapter2.item1;

import com.wenqi.learn.chapter2.item2.Calzone;
import com.wenqi.learn.chapter2.item2.NyPizza;

/**
 * @author Wenqi Liang
 * @date 2021/11/20
 */
public class MainRunMethod {


    public static void main(String[] args) {

        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(NyPizza.Topping.SAUSAGE).addTopping(NyPizza.Topping.ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(NyPizza.Topping.HAM).sauceInside().build();
    }
}
