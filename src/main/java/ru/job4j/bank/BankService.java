package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует Банковскую систему
 * @author  Elmar Isaev
 * @version 1.4
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему,
     * в случае если его еще нет в системе
     * @param user пользователь которого нужно добавить в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());

    }

    /**
     * Метод удалаяет пользователя из системы, по данным паспорта
     * @param passport паспорт удаляемого пользователя
     * @return возвращает {true} если перед удалением удалось найти пользователя по заданным параметрам,
     * иначе если такого пользователя не было в системе возвращает {false}
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет новый аккаунт к списку аккаунтов пользователя,
     * в случае если удалось найти пользователя по паспорту
     * @param passport паспорт пользователя
     * @param account аккаунт который нужно добавить в список аккаунтов пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }

    }

    /**
     * Метод позволяет найти пользователя в системе по паспорту
     * @param passport паспорт пользователя
     * @return Возврящает пользователя в формате User {@link User} если удалось его найти,
     * иначе возвращяет null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst().orElse(null);
    }

    /**
     * Метод позволяет найти аккаунт пользователя по реквизитам,
     * перед этим найдя пользователя по паспорту
     * @param passport паспорт пользователя
     * @param requisite реквизиты аккаунта
     * @return Возврящает аккаунт пользователя в формате Account {@link Account} если удалось его найти,
     * иначе возвращяет {null}
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst().orElse(null);
        }
        return null;
    }

    /**
     * Метод позволяет перевести деньги с одного аккаунта на другой,
     * Если находит пользователей по паспорту и аккаунт по реквизитам
     * @param srcPassport паспорт пользователя с аккаунта которого происходит списание средств
     * @param srcRequisite реквизиты аккаунта с которого происходит списание средств
     * @param destPassport паспорт пользователя на аккаунт которого происходит перевод средств
     * @param destRequisite реквизиты аакаунта на который происходит перевод средств
     * @param amount сумма перевода
     * @return возвращает {true} если аакаунт отправитель и аакаунт получатель найдены, и баланс ааканта отправителя
     * больше и равен сумме перевода.
     * иначе возврящает {false}
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srsAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srsAccount != null && destAccount != null && srsAccount.getBalance() >= amount) {
            srsAccount.setBalance(srsAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }

        return rsl;
    }

    /**
     * Метод позволяет найти список всех аккаунтов пользователя
     * @param user пользователь в формате User {@link User}
     * @return Возврящает список всех аккаунтов пользователя,
     * если пользовательне не найден возвращянт {null}
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}