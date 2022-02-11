package com.wenqi.learn.chapter6.item36;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liangwenqi
 * @date 2022/2/11
 */
public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Using ordinal() to index into an array - DON'T DO THIS!
     * 使用 ordinal() 对数组进行索引
     */
    Set<Plant>[] plantsByLifeCycle = new Set[LifeCycle.values().length];

    /**
     * Using an EnumMap to associate data with an enum
     * 使用 EnumMap 将数据与枚举关联
     */
    Map<LifeCycle, Set<Plant>> plantsByLifeCycleMap =new EnumMap<>(Plant.LifeCycle.class);

    public void collectPlants() {
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        Plant[] garden = new Plant[]{
                new Plant("A", LifeCycle.ANNUAL),
                new Plant("B", LifeCycle.BIENNIAL),
                new Plant("C", LifeCycle.PERENNIAL),
                new Plant("D", LifeCycle.BIENNIAL),
                new Plant("E", LifeCycle.PERENNIAL),
        };

        // 把garden中的plant按照位运算放入数组中
        for (Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        // Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }


        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycleMap.put(lc, new HashSet<>());
        }

        for (Plant p : garden) {
            plantsByLifeCycleMap.get(p.lifeCycle).add(p);
        }
        // 使用流来简化代码
        EnumMap<LifeCycle, Set<Plant>> collect = Arrays.stream(garden).collect(Collectors.groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(LifeCycle.class), Collectors.toSet()));

        System.out.println(collect);
    }
}
