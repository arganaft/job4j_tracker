package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    public boolean deleteUser(String passport) {
        return users.remove(findByPassport(passport)) != null;
    }

    public void addAccount(String passport, Account account) {
        if (!users.get(findByPassport(passport)).contains(account)) {
            users.get(findByPassport(passport)).add(account);
        }

    }

    public User findByPassport(String passport) {
        User findUser = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                findUser = user;
            }
        }
        return findUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account findAccount = null;
        if (findByPassport(passport) != null) {
            for (Account account : users.get(findByPassport(passport))) {
                if (account.getRequisite().equals(requisite)) {
                    findAccount = account;
                }
            }
        }
        return findAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User srsUser = findByPassport(srcPassport);
        User destUser = findByPassport(destPassport);
        Account srsAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srsUser != null
           && destUser != null
           && srsAccount != null
           && destAccount != null
           && srsAccount.getBalance() >= amount) {
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