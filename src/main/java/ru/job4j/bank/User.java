package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс реализует модель данных  - Пользователь
 * Банковской системой {@link BankService}
 * @author Elmar Isaev
 * @version 1.2
 */
public class User {
    private String passport;
    private String username;

    /**
     * конструктор Класса Account
     * @param passport данные паспорта пользователя, строка в формате String
     * @param username Имя пользователя, строка в формате String
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}