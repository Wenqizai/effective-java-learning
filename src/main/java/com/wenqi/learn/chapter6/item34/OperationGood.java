package com.wenqi.learn.chapter6.item34;

/**
 * Enum type with constant-specific method implementations
 * 具有特定于常量的方法实现的枚举类型
 *
 * @author liangwenqi
 * @date 2022/2/10
 */
public enum OperationGood {
    PLUS {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x, double y);
}
