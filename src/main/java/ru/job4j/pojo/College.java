package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Elmar Isaev");
        student.setGroup(2);
        student.setReceiptDate(new Date(2022, 11, 29));
        System.out.println("Student " + student.getFullName());
        System.out.println("Group " + student.getGroup());
        System.out.println("Date " + student.getReceiptDate());
    }
}
