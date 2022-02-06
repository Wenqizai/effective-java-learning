package com.wenqi.learn.chapter4.item23;

/**
 * 类层次结构优于带标签的类
 * <p>
 * Class hierarchy replacement for a tagged class
 * 标记类的类层次结构替换
 *
 * @author liangwenqi
 * @date 2022/2/6
 */
abstract class AbstractFigure {
    abstract double area();
}

class Circle extends AbstractFigure {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}

class Rectangle extends AbstractFigure {
    final double length;
    final double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}