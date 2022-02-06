package com.wenqi.learn.chapter4.item20;

import java.util.Map;
import java.util.Objects;

/**
 * @author liangwenqi
 * @date 2022/2/6
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    /**
     * Entries in a modifiable map must override this method
     * @param value
     * @return
     */
    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    /**
     * Implements the general contract of Map.Entry.equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<?, ?> e = (Map.Entry) o;
        return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
    }

    /**
     * Implements the general contract of Map.Entry.hashCode
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
