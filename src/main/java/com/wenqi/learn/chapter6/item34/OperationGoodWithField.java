package com.wenqi.learn.chapter6.item34;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enum type with constant-specific class bodies and data
 * 具有特定于常量的类主体和数据的枚举类型
 *
 * @author liangwenqi
 * @date 2022/2/10
 */
public enum OperationGoodWithField {
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

    OperationGoodWithField(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    /**
     * Implementing a fromString method on an enum type
     * 在枚举类型上实现 fromString 方法
     */
    private static final Map<String, OperationGoodWithField> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Objects::toString, e -> e));

    /**
     * Returns Operation for string, if any
     * 返回字符串的操作，如果有的话
     * @param symbol
     * @return
     */
    public static Optional<OperationGoodWithField> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("1.2");
        double y = Double.parseDouble("1.5");
        for (OperationGoodWithField op : OperationGoodWithField.values()) {
            System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
        }

        System.out.println("---------------------------");

        for (OperationGoodWithField op : OperationGoodWithField.values()) {
            System.out.printf("%f %s %f = %f%n",x, OperationGoodWithField.fromString(op.toString()).get(), y, op.apply(x, y));
        }
    }
}
