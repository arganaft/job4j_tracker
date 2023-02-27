package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());

    }

    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        User findUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                findUser = user;
                break;
            }
        }
        return findUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account findAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    findAccount = account;
                    break;
                }
            }
        }
        return findAccount;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}