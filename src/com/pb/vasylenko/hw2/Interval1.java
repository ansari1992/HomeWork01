package com.pb.vasylenko.hw2;

import java.util.Scanner;

public class Interval1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = -1;
        do {
            System.out.print("Введите целое число: ");
            try {

                 number = Integer.parseInt(sc.next());
                if (number >= 0 && number <= 14) {
                    System.out.println("Число входит в диапазон [0-14]");
                } else if (number >= 15 && number <= 35) {
                    System.out.println("Число входит в диапазон [15-35]");
                } else if (number >= 36 && number <= 50) {
                    System.out.println("Число входит в диапазон [36-50]");
                } else if (number >= 51 && number <= 100) {
                    System.out.println("Число входит в диапазон [51-100]");
                }
            } catch (Exception ex) {
                System.out.println("Не балуйся! Введи число!");
            }
        } while (number < 100);
        System.out.println("Число не входит ни в один диапазон. Bye!");
    }
}
