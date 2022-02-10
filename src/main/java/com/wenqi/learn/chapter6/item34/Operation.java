package com.wenqi.learn.chapter6.item34;

/**
 * Enum type that switches on its own value - questionable
 * 开启自己的值的枚举类型 - 值得怀疑
 *
 * @author liangwenqi
 * @date 2022/2/10
 */
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    /**
     * Do the arithmetic operation represented by this constant
     * <p>
     * 如果你添加了一个新的枚举常量，但忘记向 switch 添加相应的 case，则枚举仍将编译，但在运行时尝试应用新操作时将失败
     *
     * @param x
     * @param y
     * @return
     */
    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        throw new AssertionError("Unknown op: " + this);
    }
}
