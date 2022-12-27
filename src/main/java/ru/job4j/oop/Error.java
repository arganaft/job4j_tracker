package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error is active?: " + active);
        System.out.println("Status number: " + status);
        System.out.println("Warning message: " + message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        defaultError.printInfo();
        Error blueError = new Error(true, 1, "Blue threat level");
        blueError.printInfo();
        Error yellowError = new Error(true, 2, "Yellow threat level");
        yellowError.printInfo();
        Error redError = new Error(true, 3, "Red threat level");
        redError.printInfo();
    }
}
