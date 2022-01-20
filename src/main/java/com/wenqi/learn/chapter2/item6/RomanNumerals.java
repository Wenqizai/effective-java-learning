package com.wenqi.learn.chapter2.item6;

import java.util.regex.Pattern;

/**
 * 识别罗马数字
 *
 * @author liangwenqi
 * @date 2022/1/20
 */
public class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})\" + \"(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    /**
     *  String.matches 创建了一个Pattern实例, 并且只使用一次，之后就进行垃圾收集了。
     *  所以创建这一个 Pattern 实例是很昂贵的
     *
     * @param s
     * @return
     */
    static boolean isRomanNumeral1(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /**
     * 静态ROMAN作为类初始化的一部分，缓存它，并在每次调用 isRomanNumeral 方法时复用同一个实例, 性能更高
     *
     * @param s
     * @return
     */
    static boolean isRomanNumeral2(String s) {
        return ROMAN.matcher(s).matches();
    }
}
