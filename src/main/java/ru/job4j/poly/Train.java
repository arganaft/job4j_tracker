package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд " + getClass().getSimpleName() + " передвигается по рельсам");
    }

    @Override
    public double refuel(double fuel) {
        return 1.52213 * fuel;
    }
}
