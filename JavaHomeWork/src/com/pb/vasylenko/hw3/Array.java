package com.pb.vasylenko.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        int[] numbs = new int[10];
        while (true) {
            if (counter == numbs.length) {
                break;
            } else {
                try {
                    System.out.print("Введи целое число: ");
                    int numb = Integer.parseInt(scan.next().trim());
                    numbs[counter] = numb;
                    counter++;
                } catch (Exception ex) {
                    System.out.println("Не балуйся! Введи число!!");
                }
            }
        }
        System.out.println(Arrays.toString(numbs));
        int sum = 0;
        for (int i = 0; i < numbs.length; i++) {
            sum += numbs[i];
        }
        System.out.println("Сумма элементов: " + sum);
        sum = 0;
        for (int i = 0; i < numbs.length; i++) {
            if (numbs[i] > 0) {
                sum ++;
            }
        }
        System.out.println("Колличество положительных элементов: " + sum);
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < numbs.length - 1; i++) {
                if (numbs[i] > numbs[i + 1]) {
                    isSorted = false;

                    buf = numbs[i];
                    numbs[i] = numbs[i + 1];
                    numbs[i + 1] = buf;
                }
            }
        }System.out.println("Сортировка " + Arrays.toString(numbs));

    }
}
