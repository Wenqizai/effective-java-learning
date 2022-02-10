package com.wenqi.learn.chapter6.item34;

/**
 * Enum that switches on its value to share code - questionable
 * 打开其值以共享代码的枚举 - 值得怀疑
 *
 * @author liangwenqi
 * @date 2022/2/10
 */
public enum PayrollDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;
        int overtimePay;
        switch (this) {
            // Weekend
            case SATURDAY:
            case SUNDAY:
                overtimePay = basePay / 2;
                break;
            // Weekday
            default:
                overtimePay = minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }
        return basePay + overtimePay;
    }
}
