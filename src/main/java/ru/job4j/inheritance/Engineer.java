package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int experience;

    public Engineer(boolean degree, int experienc) {
        super(degree);
        this.experience = experience;
    }
}