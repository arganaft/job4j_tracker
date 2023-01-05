package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] notNullItems = new  Item[size];
        int notNullSize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                notNullItems[notNullSize++] = items[i];
            }
        }
        return Arrays.copyOf(notNullItems, notNullSize);
    }

    public Item[] findByName(String key) {
        Item[] itemByKey = new Item[size];
        int keySize = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                itemByKey[keySize++] = items[i];
            }
        }
        return Arrays.copyOf(itemByKey, keySize);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        if (indexOf(id) != -1) {
            item.setId(id);
            items[indexOf(id)] = item;
            return true;
        } else {
            return false;
        }
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }
}