package ru.job4j.early;

public class PasswordValidator {
    final static String[] SUBSTRINGS = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        char[] passwordArray = password.toCharArray();
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;
        boolean isLetterOrDigit = false;
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
            if (isUpperCase & isLowerCase & isDigit & isLetterOrDigit) {
                break;
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

        for (String substring : SUBSTRINGS) {
            if (password.toLowerCase().contains(substring)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }

}
