package com.wenqi.learn.chapter6.item34;

/**
 * The strategy enum pattern
 * 策略枚举模式
 *
 * @author liangwenqi
 * @date 2022/2/10
 */
public enum PayrollDayStrategy {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDayStrategy(PayType payType) {
        this.payType = payType;
    }

    PayrollDayStrategy() {
        this(PayType.WEEKDAY);
    } // Default

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    /**
     * The strategy enum type
     */
    private enum PayType {
        WEEKDAY {
            @Override
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);

        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}
