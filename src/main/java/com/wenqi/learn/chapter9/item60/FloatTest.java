package com.wenqi.learn.chapter9.item60;

import java.math.BigDecimal;

/**
 * @author liangwenqi
 * @date 2022/2/23
 */
public class FloatTest {
    public static void main(String[] args) {
        //decimalCount();
        //intCount();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }

    /**
     * bigDecimal做运算性能较差，如果数值不是太大， 可考虑使用int，long来替代，自己转换小数
     *
     * 如果数值不超过 9 位小数，可以使用 int；如果不超过 18 位，可以使用 long。如果数量可能超过 18 位，则使用 BigDecimal。
     */
    private static void intCount() {
        int itemsBought = 0;
        int funds = 100;
        for (int price = 10; funds >= price; price += 10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought +" items bought.");
        System.out.println("Cash left over: " + funds + " cents");
    }

    private static void decimalCount() {
        // 构造函数避免使用double，double会引入不准确的值
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Money left over: $" + funds);
    }

    private static void floatCount() {
        // Broken - uses floating point for monetary calculation!
        // Broken - 使用浮点数进行货币计算
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
    }
}
