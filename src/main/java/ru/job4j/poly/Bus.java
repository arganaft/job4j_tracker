package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void go() {

    }

    @Override
    public void passengers(int number) {

    }

    @Override
    public double refuel(double fuel) {
        return 49.40 * fuel;
    }

    @Override
    public void move() {
        System.out.println("Автобус " + getClass().getSimpleName() + " двигается по скоростным трассам");
    }
}
