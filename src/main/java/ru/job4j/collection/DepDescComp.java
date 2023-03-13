package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int res = o1.split("/")[0].compareTo(o2.split("/")[0]);
        if (res != 0) {
            return res * -1;
        } else {
            return o1.compareTo(o2);
        }
    }
}