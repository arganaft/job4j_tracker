package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (key, value) -> map.put(key, value);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");
        BiPredicate<Integer, String> biPred = (key, value) -> key % 2 == 0 || value.length() == 4;
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }
        Supplier<Collection<String>> sup = () -> map.values();
        List<String> strings = new ArrayList<>(sup.get());
        Consumer<String> con = str -> System.out.println(str);
        Function<String, String> func = str -> str.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}
