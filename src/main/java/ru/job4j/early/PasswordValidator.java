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
        boolean isUpperCase = false,
                isLowerCase = false,
                isDigit = false,
                isLetterOrDigit = false;
        for (char i : passwordArray) {
            if (Character.isUpperCase(i)) {
                isUpperCase = true;
            }
            if (Character.isLowerCase(i)) {
                isLowerCase = true;
            }
            if (Character.isDigit(i)) {
                isDigit = true;
            }
            if (!Character.isLetterOrDigit(i)) {
                isLetterOrDigit = true;
            }
        }
        if (!isUpperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!isLowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isLetterOrDigit) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        String[] substrings = {"qwerty", "12345", "password", "admin", "user"};
        for (String i : substrings) {
            if (password.toLowerCase().contains(i)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }

        return password;
    }

}
