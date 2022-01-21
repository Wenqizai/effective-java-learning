package com.wenqi.learn.chapter3.item10;

import java.awt.Color;
import java.util.Objects;

/**
 * Adds a value component without violating the equals contract
 * 在不违反 equals 合约的情况下添加一个 value 组件
 *
 *
 * @author liangwenqi
 * @date 2022/1/21
 */
public class ColorPoint2 {
    private final Point point;
    private final Color color;

    public ColorPoint2(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint2)) {
            return false;
        }

        ColorPoint2 cp = (ColorPoint2) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
