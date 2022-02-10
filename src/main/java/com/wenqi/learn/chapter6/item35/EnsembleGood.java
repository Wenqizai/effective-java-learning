package com.wenqi.learn.chapter6.item35;

/**
 * @author liangwenqi
 * @date 2022/2/10
 */
public enum EnsembleGood {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),SEXTET(6),
    SEPTET(7), OCTET(8), DOUBLE_QUARTET(8), NONET(9), DECTET(10),TRIPLE_QUARTET(12);

    private final int numberOfMusicians;

    EnsembleGood(int size) { this.numberOfMusicians = size; }

    public int numberOfMusicians() { return numberOfMusicians; }
}
