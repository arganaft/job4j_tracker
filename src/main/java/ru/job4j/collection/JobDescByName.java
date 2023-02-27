package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        return job2.getName().compareTo(job1.getName());
    }
}
