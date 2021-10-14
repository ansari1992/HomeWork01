package com.pb.vasylenko.hw2;

import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int operand1;
        int operand2;
        String sign;
        String insert;

        do {
            try {
                System.out.print("Введи первое число:   ");
                operand1 = sc.nextInt();
                System.out.print("Какое действие нужно выполнить +,-,*,/ ?   ");
                sign = sc.next();
                System.out.print("Введи второе число:   ");
                operand2 = sc.nextInt();


                switch (sign) {
                    case "+" -> System.out.println(operand1 + operand2);
                    case "-" -> System.out.println(operand1 - operand2);
                    case "*" -> System.out.println(operand1 * operand2);
                    case "/" -> {
                        if (operand2 == 0) {
                            throw new Exception("На ноль делить нельзя!!");
                        } else {
                            System.out.println((double) operand1 / operand2);
                        }
                    }
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            System.out.print("Ты хочешь играться дальше?   -Y/N:  ");
            insert = sc.next().toUpperCase(Locale.ROOT);
        } while (!insert.equals("N"));
        System.out.println("Good bye ^)");
    }
}
