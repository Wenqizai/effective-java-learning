package com.wenqi.learn.chapter3.item14;

import com.wenqi.learn.chapter3.item10.PhoneNumber;

import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 * @author liangwenqi
 * @date 2022/1/28
 */
public class PhoneNumberSort {

    private final short areaCode, prefix, lineNum;

    public PhoneNumberSort(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    /**
     * Multiple-field Comparable with primitive fields
     *
     * 性能较优
     *
     * @param pn
     * @return
     */
    public int compareTo(PhoneNumberSort pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix);
            if (result == 0) {
                result = Short.compare(lineNum, pn.lineNum);
            }
        }
        return result;
    }

    static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        return (o1, o2) -> 0;
    }

    /**
     *  Comparable with comparator construction methods
     *
     *  JDK8比较器比较, 性能较慢, 可考虑静态比较器构造
     */
    private static final Comparator<PhoneNumberSort> COMPARATOR = comparingInt((PhoneNumberSort pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);

    public int compareTo2(PhoneNumberSort pn) {
        return COMPARATOR.compare(this, pn);
    }


    /**
     * BROKEN difference-based comparator - violates transitivity!
     * 基于差异的比较器 - 违反传递性！ (溢出的危险)
     */
    static Comparator<Object> hashCodeOrder = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return o1.hashCode() - o2.hashCode();
        }
    };

    /**
     * Comparator based on static compare method
     *
     * 基于静态比较方法的比较器
     */
    static Comparator<Object> hashCodeOrder2 = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
    };

    /**
     * Comparator based on Comparator construction method
     *
     * 基于Comparator构造方法
     */
    static Comparator<Object> hashCodeOrder3 = Comparator
            .comparingInt(o -> o.hashCode());

}
