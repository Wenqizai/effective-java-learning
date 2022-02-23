package com.wenqi.learn.chapter9.item59;

import java.util.Random;

/**
 * @author liangwenqi
 * @date 2022/2/23
 */
public class RandomTest {
    static Random rnd = new Random();

    /**
     * Common but deeply flawed!
     * 常见但有严重缺陷！
     */
    static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static void main(String[] args) {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        // 生成 100 万个随机数，然后打印出有多少个数字落在范围的下半部分：
        for (int i = 0; i < 1000000; i++) {
            if (random(n) < n / 2) {
                low++;
            }
        }
        System.out.println(low);
    }
}
