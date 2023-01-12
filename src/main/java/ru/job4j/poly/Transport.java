package ru.job4j.poly;

public interface Transport {
    void go();

    void passengers(int number);

    double refuel(double fuel);
}
