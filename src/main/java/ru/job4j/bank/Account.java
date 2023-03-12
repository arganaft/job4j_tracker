package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс реализует модель данных - аккаунт пользователя {@link User}
 * который пользуется Банковской системой {@link BankService}
 * аккаунтов у пользователя может быть несколько
 * @author  Elmar Isaev
 * @version 1.3
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * конструктор Класса Account
     * @param requisite реквизиты аккаунта, строка в формате String
     * @param balance размеh денежной суммы на аккаунте
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
