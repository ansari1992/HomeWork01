package com.pb.vasylenko.hw4;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введи текст 1 : ");
        String firstStr = scan.nextLine().trim();
        System.out.print("Введи текст  2 : ");
        String secondStr = scan.nextLine().trim();
        System.out.println("Эти 2 выражения - анаграмма? -  " + isAnagram(firstStr.toUpperCase(Locale.ROOT), secondStr.toUpperCase(Locale.ROOT)));
    }

    private static boolean isAnagram(String firstStr, String secondStr) {
        if (firstStr.equals(secondStr)) {
            return false;
        } else {
            int first = getCharsArr(firstStr);
            int second = getCharsArr(secondStr);
            return first == second;
        }
    }

    private static int getCharsArr(String secondStr) {
        ArrayList<Character> chars = new ArrayList<>();
        for (int i = 0; i < secondStr.length(); i++) {
            if (Character.isLetter(secondStr.charAt(i)) || Character.isDigit(secondStr.charAt(i))) {
                chars.add(secondStr.charAt(i));
            }
        }
        return chars.stream().mapToInt(i -> i).sum();
    }
}
