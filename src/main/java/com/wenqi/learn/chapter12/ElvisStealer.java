package com.wenqi.learn.chapter12;

import java.io.Serializable;

/**
 * @author liangwenqi
 * @date 2022/3/14
 */
public class ElvisStealer implements Serializable {
    static Elvis impersonator;
    private Elvis payload;

    private Object readResolve() {
        // Save a reference to the "unresolved" Elvis instance
        impersonator = payload;
        // Return object of correct type for favoriteSongs field
        return new String[]{"A Fool Such as I"};
    }

    private static final long serialVersionUID = 0;
}
