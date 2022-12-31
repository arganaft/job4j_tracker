package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String programLang;

    public Programmer(String programLang, int experienc, boolean degree) {
        super(degree, experienc);
        this.programLang = programLang;
    }
}