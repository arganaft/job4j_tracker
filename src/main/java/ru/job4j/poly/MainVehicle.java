package ru.job4j.poly;

public class MainVehicle {
    public static void main(String[] args) {
        Vehicle schoolBus = new Bus();
        Vehicle il96 = new Airplane();
        Vehicle sapsan = new Train();

        Vehicle[] transportFleet = new Vehicle[] {schoolBus, il96, sapsan};
        for (Vehicle transport: transportFleet) {
            transport.move();
            System.out.println("стоимость 1 единицы топлива составляет " + transport.refuel(1));
        }
    }

}
