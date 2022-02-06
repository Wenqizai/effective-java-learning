package com.wenqi.learn.chapter4.item22;

import static com.wenqi.learn.chapter4.item22.PhysicalConstants.*;

/**
 * @author liangwenqi
 * @date 2022/2/6
 */
public class Test {

    double atoms(double mols) {
        return AVOGADROS_NUMBER * mols;
    }

    // Many more uses of PhysicalConstants justify static import
}
