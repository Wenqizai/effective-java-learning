package com.wenqi.learn.chapter8.item50;

import java.util.Date;

/**
 * Broken "immutable" time period class
 * 打破不可变类
 *
 * @author liangwenqi
 * @date 2022/2/21
 */
public class Period {
    private final Date start;
    private final Date end;

    /**
     * @param start the beginning of the period
     * @param end the end of the period; must not precede start
     * @throws IllegalArgumentException if start is after end
     * @throws NullPointerException if start or end is null
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

    public static void main(String[] args) {
        // Attack the internals of a Period instance
        // 攻击 Period 实例的内部
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        // Modifies internals of p!
        // 破坏Period的不可变行
        end.setYear(78);
    }
}
