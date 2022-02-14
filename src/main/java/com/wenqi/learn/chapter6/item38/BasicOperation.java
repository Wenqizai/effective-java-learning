package com.wenqi.learn.chapter6.item38;

/**
 * Emulated extensible enum using an interface
 * 使用接口模拟可扩展枚举
 * <p>
 * 枚举类型（BasicOperation）是不可扩展的，而接口类型（Operation）是可扩展的
 *
 * @author liangwenqi
 * @date 2022/2/14
 */
public enum BasicOperation implements Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
