package com.pb.vasylenko.hw3;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int random = rand.nextInt(101);
        System.out.println("random = " + random + "\n");
        int attempt = 0;
        String number;
        System.out.println("Угадай целое число от 0 до 100");
        System.out.println("Для выхода из программы введи - exit");
        do {
            attempt++;
            System.out.println("\n" + "********Попытка №" + attempt + "********");
            System.out.print("введи число  ");
            number = sc.next().toUpperCase(Locale.ROOT);
            if (number.toUpperCase(Locale.ROOT).equals("EXIT")) {break;}
            else {
                if (number.matches("-?\\d+")) {
                    int userNumber = Integer.parseInt(number);
                    if (userNumber > 100 || userNumber < 0) {
                        System.out.println("Не балуйся! Введи число от 0 до 100!");
                    } else {
                        if (userNumber == random) {
                            System.out.println("Молодец, угадал c " + attempt + " попытки");
                            break;
                        } else {
                            if (random > userNumber) {
                                System.out.println("загаданное число больше, чем введено");


                            } else {
                                System.out.println("загаданное число меньше, чем введено");
                            }
                        }
                    }
                } else {
                    System.out.print("введи число или exit");
                }
            }


        } while (true);
        System.out.println("Good bye ^)");
    }
}




