package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman beginner = new Freshman();
        Student experienced = beginner;
        Object unique = experienced;
    }
}
