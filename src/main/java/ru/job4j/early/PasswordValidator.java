package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        char[] passwordArray = password.toCharArray();
        boolean flag = false;
        for (char i : passwordArray) {
            if (Character.isUpperCase(i)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        flag = false;
        for (char i : passwordArray) {
            if (Character.isLowerCase(i)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        flag = false;
        for (char i : passwordArray) {
            if (Character.isDigit(i)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        flag = false;
        for (char i : passwordArray) {
            if (!Character.isLetterOrDigit(i)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        if (password.toLowerCase().contains("qwerty")
        || password.toLowerCase().contains("12345")
        || password.toLowerCase().contains("password")
        || password.toLowerCase().contains("admin")
        || password.toLowerCase().contains("user")) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }

        return password;
    }

}
