package org.kniit.lab10.task22;

import java.util.HashMap;
import java.util.Map;

public class Dictionary<K, V> {
    private Map<K, V> map = new HashMap<>();

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public void remove(K key) {
        map.remove(key);
    }
}
