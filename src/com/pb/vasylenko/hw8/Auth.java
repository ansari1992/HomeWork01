package com.pb.vasylenko.hw8;

import java.util.Objects;

public class Auth {
    private String login;
    private String password;


    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (loginChecked(login)) {
            if (passwordChecked(password, confirmPassword)) {
                this.login = login;
                this.password = password;
            } else {
                throw new WrongPasswordException("Authorization failed");
            }
        } else {
            throw new WrongLoginException("Authorization failed");
        }

    }

    private boolean loginChecked(String login) {
        return login.matches("^[a-zA-Z0-9]{5,20}");
    }

    private boolean passwordChecked(String password, String confirmPassword) {
        if (Objects.equals(password, confirmPassword)) {
            return password.matches("^[a-zA-Z0-9-_]{5,}");
        }
        return false;
    }

    public void signIn(String login, String password) throws WrongLoginException {
        if (Objects.equals(this.login, login) && Objects.equals(this.password, password)) {
            System.out.println("Good gob!! ^)");
        } else {
            throw new WrongLoginException("Authorization failed");
        }
    }
}
