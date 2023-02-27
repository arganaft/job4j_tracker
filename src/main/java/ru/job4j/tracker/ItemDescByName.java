package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item firstItem, Item lastItem) {
        return lastItem.getName().compareTo(firstItem.getName());
    }
}
