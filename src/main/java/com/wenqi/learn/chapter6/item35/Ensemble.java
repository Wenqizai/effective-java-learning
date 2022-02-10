package com.wenqi.learn.chapter6.item35;

/**
 * Abuse of ordinal to derive an associated value - DON'T DO THIS
 * 滥用序数以得出相关值 - 不要这样做
 *
 * @author liangwenqi
 * @date 2022/2/10
 */
public enum Ensemble {

    SOLO, DUET, TRIO, QUARTET, QUINTET,SEXTET, SEPTET, OCTET, NONET, DECTET;

    /**
     * ordinal()方法返回枚举的声明中的位置的整数, 最好不要使用, 否则枚举变换位置后将会引发灾难
     * @return
     */
    public int numberOfMusicians() { return ordinal() + 1; }

    public static void main(String[] args) {
        System.out.println(Ensemble.SOLO.numberOfMusicians());
    }
}
