package org.kniit.lab10.task20;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Number> {
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public double sum() {
        double cnt = 0.0;
        for (T item : items) {
            cnt += item.doubleValue();
        }
        return cnt;
    }
}
