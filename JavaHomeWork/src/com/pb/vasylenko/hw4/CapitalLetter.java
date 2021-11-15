package com.pb.vasylenko.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {

                Scanner scan = new Scanner(System.in);
                System.out.print("Введи текст : ");
                String words = scan.nextLine().trim();
                System.out.println("Результат: " + CapitalLetter.toTitleCase(words));
            }

            public static String toTitleCase(String str) {
                StringBuilder result = new StringBuilder();
                for (String word : str.split("\\s")) {
                    result.append(word.replaceFirst(word.charAt(0) + "", Character.toUpperCase(word.charAt(0)) + "")).append(" ");
                }
                return result.toString();
            }
        }


