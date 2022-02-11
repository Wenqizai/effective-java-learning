package com.wenqi.learn.chapter6.item36;

import javafx.animation.Transition;

/**
 * Using ordinal() to index array of arrays - DON'T DO THIS!
 * 使用 ordinal() 作为数组索引
 *
 * @author liangwenqi
 * @date 2022/2/11
 */
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        /**
         * Rows indexed by from-ordinal, cols by to-ordinal
         */
        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        /**
         * Returns the phase transition from one phase to another
         * @param from
         * @param to
         * @return
         */
        public static Transition from(Phase from, Phase to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
