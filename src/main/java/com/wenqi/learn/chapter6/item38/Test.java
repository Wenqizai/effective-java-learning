package com.wenqi.learn.chapter6.item38;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author liangwenqi
 * @date 2022/2/14
 */
public class Test {
    public static void main(String[] args) {
        //Operation op = BasicOperation.DIVIDE;
        //System.out.println(op.apply(15, 3));
        //op=ExtendedOperation.EXP;
        //System.out.println(op.apply(2,5));



        double x = Double.parseDouble("12");
        double y = Double.parseDouble("10");
        test(ExtendedOperation.class, x, y);


        test(Arrays.asList(BasicOperation.values()), x, y);

    }


    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
        }
    }

    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
        }
    }
}
