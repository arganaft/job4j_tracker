package ru.job4j.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ScheduleTask {
    private PriorityQueue<Task> queue;

    public ScheduleTask(Comparator<Task> comparator) {
        this.queue = new PriorityQueue<>(comparator);
    }

    public void addTask(Task task) {
        this.queue.offer(task);
    }

    public Task readTask() {
        return this.queue.peek();
    }

    public Task getTask() {
        return this.queue.poll();
    }
}
