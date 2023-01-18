package ru.job4j.ex;
public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User findUser = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                findUser = user;
                break;
            }
        }
        if (findUser == null) {
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
            if (user != null && validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException iv) {
            iv.printStackTrace();
        } catch (UserNotFoundException nf) {
            nf.printStackTrace();
        }
    }
}