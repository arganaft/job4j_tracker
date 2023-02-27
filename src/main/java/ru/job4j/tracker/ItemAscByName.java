package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item firstItem, Item lastItem) {
        return firstItem.getName().compareTo(lastItem.getName());
    }
}
