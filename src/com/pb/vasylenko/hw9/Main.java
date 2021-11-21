package com.pb.vasylenko.hw9;

public class Main{
    public static void main(String[] args) {
        String oldPath = "D:/numbers.txt";
        String newPath = "D:/odd-numbers.txt";
        String del = "\s";
        FileNumbers numbers = new FileNumbers(oldPath, newPath, del);
        System.out.println("It's alive !!! :)");
        try {
            numbers.createNumbersFile();
            System.out.println("File was created !!! :)");
            numbers.createOddNumbersFile();
            System.out.println("Odd file was created !!! :)");
        } catch (Exception ex) {
            System.out.println("Ups.. Exception :( -> " + ex.getLocalizedMessage());
        }
    }
}