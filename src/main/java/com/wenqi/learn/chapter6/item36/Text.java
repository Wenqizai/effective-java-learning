package com.wenqi.learn.chapter6.item36;

/**
 * Bit field enumeration constants - OBSOLETE!
 * 位表示枚举常量 - 已过时
 *
 * @author liangwenqi
 * @date 2022/2/11
 */
public class Text {
    public static final int STYLE_BOLD = 1 << 0; // 1
    public static final int STYLE_ITALIC = 1 << 1; // 2
    public static final int STYLE_UNDERLINE = 1 << 2; // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8

    /**
     * Parameter is bitwise OR of zero or more STYLE_ constants
     * 参数是零个或多个 STYLE_ 常量的按位或
     *
     * @param styles
     */
    public void applyStyles(int styles) {
    }
}
