package com.wenqi.learn.chapter6.item36;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Using a nested EnumMap to associate data with enum pairs
 * 使用嵌套的 EnumMap 将数据与枚举对关联
 *
 * @author liangwenqi
 * @date 2022/2/11
 */
public enum PhaseGood {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final PhaseGood from;
        private final PhaseGood to;

        Transition(PhaseGood from, PhaseGood to) {
            this.from = from;
            this.to = to;
        }

        /**
         * Initialize the phase transition map
         * 初始化transition map
         */
        private static final Map<PhaseGood, Map<PhaseGood, Transition>> m = Stream.of(values())
                .collect(Collectors.groupingBy(
                            t -> t.from,
                            () -> new EnumMap<>(PhaseGood.class),
                            Collectors.toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(PhaseGood.class))
                        )
                );

        /**
         * 初始化transition map (简化初始化流程)
         */
        private static final Map<PhaseGood, Map<PhaseGood, Transition>> map = new EnumMap<>(PhaseGood.class);

        static{
            for (PhaseGood p : PhaseGood.values()) {
                map.put(p, new EnumMap<>(PhaseGood.class));
            }

            for (Transition trans : Transition.values() ) {
                map.get(trans.from).put(trans.to, trans) ;
            }
        }

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }
}
