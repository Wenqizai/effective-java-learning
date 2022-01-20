package com.wenqi.learn.chapter2.item6;

/**
 * @author liangwenqi
 * @date 2022/1/20
 */
public class CreateAndDestroyObject {

    public void createString() {
        // 每次都会创建实例
        String bad = new String("bikini");

        // 实例可以复用
        String good = "bikini";
    }

    /**
     * Hideously slow! Can you spot the object creation?
     * @return
     */
    private static long sum() {
        // 声明为Long类型而不是基本类型long, sum += i 需要装箱操作, 创建不必要的Long实例
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - start);
        return sum;
    }

    /**
     * @return
     */
    private static long sum2() {
        // 使用基本类型long
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - start);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(CreateAndDestroyObject.sum());
        System.out.println(CreateAndDestroyObject.sum2());
    }
}
