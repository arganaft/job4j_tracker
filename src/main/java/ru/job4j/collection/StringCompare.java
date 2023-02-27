package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int minLenth = Math.min(left.length(), right.length());
        char[] leftCharArea = left.toCharArray();
        char[] rightCharArea = right.toCharArray();
        for (int i = 0; i < minLenth; i++) {
            int compare = Character.compare(leftCharArea[i], rightCharArea[i]);
            if (compare != 0) {
                result = compare;
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = left.length() - right.length();
        }
        return result;
    }
}