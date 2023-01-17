package ru.job4j.ex;

import java.util.Objects;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User findUser = null;
        for (User user: users) {
            if (login.equals(user.getUsername())) {
                findUser = user;
            }
        }
        if (Objects.equals(findUser, null)) {
            throw new UserNotFoundException("User " + login + " not found");
        }
        return findUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("User" + user.getUsername() + " is invalide");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("User name length < 3");
        }
        return user.isValid() && user.getUsername().length() >= 3;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (!Objects.equals(user, null) && validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException iv) {
            iv.printStackTrace();
        }
    }
}