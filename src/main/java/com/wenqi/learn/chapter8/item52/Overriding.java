package com.wenqi.learn.chapter8.item52;

import java.util.Arrays;
import java.util.List;

/**
 * 如果子类重写父类的方法, 那么子类对象调用重写的方法永远都是子类重写之后的方法, 不会调用父类的方法
 *
 * @author liangwenqi
 * @date 2022/2/22
 */
public class Overriding {
    public static void main(String[] args) {
        List<Wine> wineList = Arrays.asList(new Wine(), new SparklingWine(), new Champagne());
        for (Wine wine : wineList) {
            // 打印次序: wine -> sparkling wine -> champagne
            System.out.println(wine.name());
        }
    }
}

class Wine {
    String name() { return "wine";}
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "sparkling wine";
    }
}

class Champagne extends SparklingWine {
    @Override
    String name() { return "champagne"; }
}