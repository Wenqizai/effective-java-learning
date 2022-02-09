package com.wenqi.learn.chapter5.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Typesafe heterogeneous container pattern - implementation
 * 类型安全的异构容器模式 - 实现
 *
 * @author liangwenqi
 * @date 2022/2/9
 */
public class Favorites {
    private final Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    /**
     * put时完成类型转换
     * Achieving runtime type safety with a dynamic cast
     * 使用动态转换实现运行时类型安全
     * @param type
     * @param instance
     * @param <T>
     */
    public <T> void putFavorite2(Class<T> type, T instance) {
        favorites.put(type, type.cast(instance));
    }

}
