package com.wenqi.learn.chapter6.item40;

import java.util.HashSet;
import java.util.Set;

/**
 * Can you spot the bug?
 *
 * 没有添加@Override注解带来的隐藏Bug
 *
 * @author liangwenqi
 * @date 2022/2/16
 */
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    /**
     * 此方法为重载, 不是重写
     * @param b
     * @return
     */
    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    /**
     * 正确的重写equals方法, 入参为Object
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bigram)) {
            return false;
        }
        Bigram b = (Bigram) o;
        return b.first == first && b.second == second;
    }

    /**
     * 此方法为重载, 不是重写
     * @return
     */
    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }

        System.out.println(s.size());
    }
}
