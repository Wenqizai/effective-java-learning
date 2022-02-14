package com.wenqi.learn.chapter6.item38;

/**
 * Emulated extension enum
 * 模拟扩展枚举
 *
 * @author liangwenqi
 * @date 2022/2/14
 */
public enum ExtendedOperation implements Operation {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
