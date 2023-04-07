package ru.croc.java.homework4.secondTask;

import java.util.Objects;

/**
 * класс реализующий пару элементов
 * @param <K> тип ключа
 * @param <V> тип значения
 */
public class Pair<K,V> {
    /**
     * ключ
     */
    private final K key;
    /**
     * значение
     */
    private final V value;

    /**
     * получение ключа
     * @return ключ
     */

    public K getKey() {
        return key;
    }

    /**
     * получение значения
     * @return значение
     */
    public V getValue() {
        return value;
    }

    /**
     * конструкток принимающий ключ, значение
     * @param key ключ
     * @param value значение
     */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) &&
                Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
