package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        StringBuilder start = new StringBuilder();
        for (String value : deps) {
            for (String el : value.split("/")) {
                start.append(el);
                tmp.add(String.valueOf(start));
                start.append("/");
            }
            start.setLength(0);
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}