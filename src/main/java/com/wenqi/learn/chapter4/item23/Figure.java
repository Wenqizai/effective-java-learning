package com.wenqi.learn.chapter4.item23;

/**
 * Tagged class - vastly inferior to a class hierarchy!
 *
 * 标记类 - 大大降低类层次结构！
 *
 * 这样的标签类有许多缺点。它们充斥着样板代码，包括 enum 声明、标签字段和 switch 语句。因为多个实现在一个类中混杂，会造成可读性受损。内存占用也增加了，因为实例被其他类型的不相关字段所拖累。
 *
 * @author liangwenqi
 * @date 2022/2/6
 */
public class Figure {
    enum Shape{RECTANGLE, CIRCLE};
    /**
     * Tag field - the shape of this figure
     *
     * 标记属性 - 图的形状
     *
     */
    final Shape shape;

    /**
     * These fields are used only if shape is RECTANGLE
     *
     * 仅当 shape 为长方形时才使用此字段
     *
     */
    double length;

    double width;

    /**
     * This field is used only if shape is CIRCLE
     *
     * 仅当 shape 为圆形时才使用此字段
     */
    double radius;

    /**
     * Constructor for circle
     * @param radius
     */
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    /**
     * Constructor for rectangle
     * @param length
     * @param width
     */
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError(shape);
        }
    }
}
