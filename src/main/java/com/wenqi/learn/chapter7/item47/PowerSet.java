package com.wenqi.learn.chapter7.item47;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Returns the power set of an input set as custom collection
 * 将输入集的幂集返回为自定义集合
 *
 * @author liangwenqi
 * @date 2022/2/17
 */
public class PowerSet {
    public static <E> Collection<Set<E>> of(Set<E> s) {
        List<E> eList = new ArrayList<>(s);

        if (eList.size() > 30) {
            throw new IllegalArgumentException("Set too big" + s);
        }

        return new AbstractList<Set<E>>() {
            @Override
            public int size() {
                return 1 << eList.size(); // 2 to the power srcSize
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && eList.containsAll((Set) o);
            }

            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        result.add(eList.get(i));
                    }
                }
                return result;
            }
        };
    }
}
