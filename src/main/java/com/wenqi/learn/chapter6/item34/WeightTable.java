package com.wenqi.learn.chapter6.item34;

/**
 * @author liangwenqi
 * @date 2022/2/10
 */
public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n",p, p.surfaceWeight(mass));
        }
    }
}
