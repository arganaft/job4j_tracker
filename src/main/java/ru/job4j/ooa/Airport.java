package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        final Airbus airbus = new Airbus("A320");
        System.out.println(airbus);
        airbus.printModel();
        System.out.println(airbus.countEngine());

        Airbus newAirbus = new Airbus("A398");
        System.out.println(newAirbus);
        newAirbus.printModel();
        System.out.println(newAirbus.countEngine());
    }
}
