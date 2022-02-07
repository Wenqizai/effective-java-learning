package com.wenqi.learn.chapter5.item26;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author liangwenqi
 * @date 2022/2/6
 */
public class UnsafeAdd {
    // Fails at runtime - unsafeAdd method uses a raw type (List)!

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        // Has compiler-generated cast
        // strings.get(0) 的结果强制转换为字符串, 报ClassCastException
        System.out.println(strings.get(0));


        // 编译不通过, List<String> 不能放入 List<Object>中
        //unsafeAdd2(strings, Integer.valueOf(42));
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static void unsafeAdd2(List<Object> list, Object o) {
        list.add(o);
    }

    /**
     * Use of raw type for unknown element type - don't do this!
     * 对未知元素类型使用原始类型 - 不要这样做！
     *
     * 安全的替代方法是使用无界通配符类型.
     * 如果你想使用泛型，但不知道或不关心实际的类型参数是什么，那么可以使用问号代替。
     * 例如，泛型集 `Set<E>` 的无界通配符类型是 `Set<?>`（读作「set of some type」）。
     * 它是最通用的参数化集合类型，能够容纳任何集合：
     *
     * @param s1
     * @param s2
     * @return
     */
    static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    static void numElementsInCommon2(Set s1) {
        Object o = new Object();
        // Legitimate use of raw type - instanceof operator
        // 原始类型的合法使用 - instanceof 运算符
        // 如果instanceof符合则必须将其强制转换为通配符类型Set<?>
        if (o instanceof Set) { // Raw type
            Set<?> s = (Set<?>) o; // Wildcard type
        }
    }

    /**
     *  Uses unbounded wildcard type - typesafe and flexible
     *  使用无界通配符类型 - 类型安全且灵活
     *
     * @param s1
     * @param s2
     * @return
     */
    static int numElementsInCommonGood(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

}
