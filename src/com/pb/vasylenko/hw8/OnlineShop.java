package com.pb.vasylenko.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Auth newAuth = new Auth();
        Scanner scan = new Scanner(System.in);
        String login;
        String password;
        String confirmPassword;
        try {
            System.out.println("Good afternoon ^)");
            System.out.println("Please enter your login");
            login = scan.nextLine().trim();
            System.out.println("Please enter your password");
            password = scan.nextLine().trim();
            System.out.println("Please confirm your password");
            confirmPassword = scan.nextLine().trim();
            newAuth.signUp(login, password, confirmPassword);
            System.out.println("Congratulations - you are registered");
            System.out.println("Login to the site for further work");
            System.out.println("Please enter your login");
            login = scan.nextLine().trim();
            System.out.println("Please enter your password");
            password = scan.nextLine().trim();
            newAuth.signIn(login, password);
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println("Sorry, but you have exception: " + ex.getLocalizedMessage());
        }
    }
}
