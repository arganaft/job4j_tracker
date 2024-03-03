package ru.job4j.tracker;

import java.util.List;

public class TestGC implements UserAction {
    private final Output out;

    public TestGC(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Test GC";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Start test GC ===");
        int count = input.askInt("Введите кол-во заявок ");
        for (int j = 0; j < 10; j++) {
            long addStartTime = System.currentTimeMillis();
                for (int i = 0; i < count; i++) {
                    tracker.add(new Item("Заявка № " + i));
                }
            long addEndTime = System.currentTimeMillis();

            long deleteStartTime = System.currentTimeMillis();
                List<Item> allItems = tracker.findAll();
                List<Integer> collect = allItems.stream()
                        .map(Item::getId).toList();
                for (Integer integer : collect) {
                    tracker.delete(integer);
                }
            long deleteEndTime = System.currentTimeMillis();
            out.println((j + 1) + ". Добавление: " + (addEndTime - addStartTime) +
                    " Удаление: " + (deleteEndTime - deleteStartTime));
        }

        out.println("Добавлено заявок: " + count);
        return true;
    }
}
