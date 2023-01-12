package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет " + getClass().getSimpleName() + " летает по воздуху");
    }

    @Override
    public double refuel(double fuel) {
        return 55.44 * fuel;
    }
}
