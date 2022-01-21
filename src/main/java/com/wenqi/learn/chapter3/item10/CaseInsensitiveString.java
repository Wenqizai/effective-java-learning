package com.wenqi.learn.chapter3.item10;

import java.util.Objects;

/**
 * Broken - violates symmetry!
 * 违反对称性
 *
 * @author liangwenqi
 * @date 2022/1/21
 */
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    /**
     * 违反对称性的equals实现
     *
     * 违反对称性的equals实现, 如果将这类对象放在List中, 将会引发灾难的现场
     * (因为List获取元素就是根据equal方法来获取的)
     *
     * @param obj
     * @return
     */
    public boolean equalsBad(Object obj) {
        // s.equals(obj) = true, obj.equals(s)不等于true
        // 右边obj变为小写比较, 导致交换位置之后equal出现false的情况, 违反对称性
        if (obj instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString)obj).s);
        }

        // One-way interoperability!
        if (obj instanceof String) {
            return s.equalsIgnoreCase((String)obj);
        }

        // Remainder omitted
        return false;
    }

    /**
     * 正确的equals实现
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof CaseInsensitiveString && s.equalsIgnoreCase(((CaseInsensitiveString)obj).s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
    }
}
