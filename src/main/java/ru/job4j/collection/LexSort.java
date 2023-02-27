package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = 0;
        String[] numberLeft = left.split(". ");
        String[] numberRight = right.split(". ");
        for (int i = 0; i < Math.min(numberRight.length, numberLeft.length); i++) {
            int compare = Integer.compare(Integer.parseInt(numberLeft[i]), Integer.parseInt(numberRight[i]));
            if (compare != 0) {
                result = compare;
                break;
            }
        }
        if (result == 0) {
            result = numberLeft.length - numberRight.length;
        }
        return result;
    }
}