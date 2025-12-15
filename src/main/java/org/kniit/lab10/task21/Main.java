package org.kniit.lab10.task21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> res = new ArrayList<>();

        for (T elem : list) {
            if (predicate.test(elem)) {
                res.add(elem);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> filtered = filter(words, s -> s.startsWith("b"));
        System.out.println(filtered);
    }
}
