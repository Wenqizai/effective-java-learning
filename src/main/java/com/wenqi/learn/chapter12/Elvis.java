package com.wenqi.learn.chapter12;

import java.io.Serializable;
import java.util.Arrays;

/**
 *  Broken singleton - has nontransient object reference field!
 *
 * @author liangwenqi
 * @date 2022/3/14
 */
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    /**
     * readResolve for instance control - you can do better!
     *
     * @return
     */
    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }
}
