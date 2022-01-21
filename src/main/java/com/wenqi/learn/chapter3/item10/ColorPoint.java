package com.wenqi.learn.chapter3.item10;

import java.awt.Color;
import java.util.Objects;

/**
 * 继承Point, 却忘了Point重写equals方法
 *
 * @author liangwenqi
 * @date 2022/1/21
 */
public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * Broken - violates symmetry!
     * 违反对称性
     * @param o
     * @return
     */
    public boolean equalsBad1(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    /**
     * Broken - violates transitivity!
     * 违反传递行
     *
     * @param o
     * @return
     */
    public boolean equalsBad2(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        // If o is a normal Point, do a color-blind comparison
        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        // o is a ColorPoint; do a full comparison
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        ColorPoint that = (ColorPoint) o;
        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    public static void main(String[] args) {
        // 1. 违反对称性
        Point c1 = new Point(1, 2);
        ColorPoint c2 = new ColorPoint(1, 2, Color.WHITE);

        System.out.println(c1.equals(c2));  // true
        System.out.println(c2.equals(c1)); // false

        System.out.println();

        // 2. 违反传递性
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

        System.out.println(p1.equals(p2));  // true
        System.out.println(p2.equals(p3));  // true
        System.out.println(p1.equals(p3));  // false
    }
}
