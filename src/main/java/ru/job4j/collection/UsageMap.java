package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ElIsaeva@mail.ru", "Елена Исаева");
        map.put("k5t3hi@mail.ru", "Сергей Дмитриев");
        map.put("PArsetyev@mail.ru", "Пётр Арсентьев");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
