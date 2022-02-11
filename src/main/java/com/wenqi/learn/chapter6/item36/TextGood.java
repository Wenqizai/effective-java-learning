package com.wenqi.learn.chapter6.item36;

import java.util.EnumSet;
import java.util.Set;

/**
 * 使用枚举代替位表示标志
 * @author liangwenqi
 * @date 2022/2/11
 */
public class TextGood {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    /**
     * Any Set could be passed in, but EnumSet is clearly best
     * 任何 Set 都可以传入，但 EnumSet 显然是最好的
     * @param styles
     */
    public void applyStyles(Set<Style> styles) {  }

    public static void main(String[] args) {
        TextGood textGood = new TextGood();
        textGood.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
