package com.wenqi.learn.chapter8.item50;

import java.util.Date;

/**
 * 防御性副本是在检查参数的有效性之前制作的，有效性检查是在副本上而不是在正本上执行的
 *
 * @author liangwenqi
 * @date 2022/2/21
 */
public class Period3 {
    private final Date start;
    private final Date end;

    /**
     * Repaired constructor - makes defensive copies of parameters
     * 修复构造函数 - 制作参数的防御性副本
     * @param start
     * @param end
     */
    public Period3(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start + " after " + this.end);
        }
    }

    /**
     * Repaired accessors - make defensive copies of internal fields
     * 修复访问器攻击 - 制作内部字段的防御性副本
     * @return
     */
    public Date start() {
        return new Date(start.getTime());
    }
    public Date end() {
        return new Date(end.getTime());
    }

    public static void main(String[] args) {
        // 虽然替换构造函数成功地防御了之前的攻击，但是仍然可以修改 Period 实例，因为它的访问器提供了对其可变内部结构的访问：
        // Second attack on the internals of a Period instance
        // 对 Period 实例内部的第二次攻击
        Date start = new Date();
        Date end = new Date();
        Period3 p = new Period3(start, end);
        // Modifies internals of p!
        // 破坏Period的不可变行
        p.end.setYear(78);
    }
}
