package com.wenqi.learn.chapter3.item10;

import java.util.Objects;

/**
 * @author liangwenqi
 * @date 2022/1/21
 */
public class Status {

    public static void main(String[] args) {
        OverrideStatus s1 = new OverrideStatus();
        OverrideStatus s2 = new OverrideStatus();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println();

        NotOverrideStatus s3 = new NotOverrideStatus();
        NotOverrideStatus s4 = new NotOverrideStatus();
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
    }

    static class NotOverrideStatus {
        public String status;
    }


    static class OverrideStatus {
        public String status;

        @Override
        public boolean equals(Object o) {
           return Objects.equals(status, ((OverrideStatus)o).status);
        }
    }


}
