package ru.job4j.collection;

import java.util.Comparator;

public class JobAscByName implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        return job1.getName().compareTo(job2.getName());
    }
}
