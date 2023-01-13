package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void go() {
        System.out.println("Автобус двигается соскоростью 80 км/ч");
    }

    @Override
    public void passengers(int number) {
        System.out.println("Вместимость автобуса 60 человек");
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
