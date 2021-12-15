package com.pb.vasylenko.hw11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        TelephoneBook book = new TelephoneBook();
        if (book.fromFile()) {
            System.out.println("Данные успешно подгружены из дампа памяти :) Приятной работы");
        } else {
            System.out.println("Система включена :) Приятной работы");
        }
        Scanner scanner = new Scanner(System.in);
        boolean isOut;
        do {
            StringBuilder input = new StringBuilder();
            System.out.println("Для просмотра нажмите 1");
            System.out.println("Для добавления нажмите 2");
            System.out.println("Для удаления нажмите 3");
            System.out.println("Для редактирования нажмите 4");
            System.out.println("Для сортировки нажмите 5");
            System.out.println("Для поиска нажмите 6");
            System.out.println("Для выхода нажмите 7");
            System.out.print("\n" + "Введите ваш выбор -> ");
            input.append(scanner.next().trim());
            System.out.print("\n");
            isOut = userChose(input, book, scanner);
            System.out.print("\n");
        } while (!isOut);
        if (book.toFile()) {
            System.out.println("Данные успешно загружены в дамп памяти :) Всего хорошего");
        } else {
            System.out.println("Не удалось загрузить данные в дамп памяти:) Всего хорошего");
        }
    }

    private static boolean userChose(StringBuilder input, TelephoneBook book, Scanner scanner) {
        try {
            int chose = Integer.parseInt(String.valueOf(input));
            if (chose < 1 || chose > 7) {
                System.out.println("Уточните свой выбор");
                return false;
            } else {
                switch (chose) {
                    case 1:
                        viewing(book);
                        return false;
                    case 2:
                        addPerson(book, scanner);
                        return false;
                    case 3:
                        deletePerson(book, scanner);
                        return false;
                    case 4:
                        editingPerson(book, scanner);
                        return false;
                    case 5:
                        sortPerson(book, scanner);
                        return false;
                    case 6:
                        searchPerson(book, scanner);
                        return false;
                    case 7:
                        return true;
                }
            }
        } catch (Exception exception) {
            System.out.println("Выбор не корректный!");
        }
        return false;
    }

    private static void searchPerson(TelephoneBook book, Scanner scanner) {
        System.out.print("Введите имя контакта  -> ");
        String personName = scanner.next().toUpperCase(Locale.ROOT).trim();
        viewing(new TelephoneBook(book.getPersonsList().stream().filter(u -> u.getName().equals(personName)).collect(Collectors.toList())));
    }

    private static void sortPerson(TelephoneBook book, Scanner scanner) {
        System.out.println("По имени 1");
        System.out.println("По дате рождения 2");
        System.out.println("По дате кол-ву телефонов 3");
        System.out.println("По дате кол-ву телефонов 4");
        System.out.println("По дате редактирования 5");
        System.out.print("Введите Ваш выбор -> ");
        String number = scanner.next().toUpperCase(Locale.ROOT).trim();
        if (isNumber(number)) {
            int num = Integer.parseInt(number);
            if (num > 0 && num < 6) {
                book.setPersonsList(book.getPersonsList().stream().sorted(book.sortBy(num)).collect(Collectors.toList()));
                viewing(book);
            } else {
                System.out.print("Такой контакт не найден!");
            }
        } else {
            System.out.print("Не корректный ввод!");
        }
    }

    private static void showPersonsList(TelephoneBook book) {
        for (int i = 0; i < book.getPersonsList().size(); i++) {
            System.out.println((i + 1) + ": " + book.getPersonsList().get(i));
        }
    }

    private static boolean isNumber(String num) {
        return num.matches("^[0-9]");
    }

    private static Person chosePerson(TelephoneBook book, Scanner scanner) {
        showPersonsList(book);
        System.out.print("Выберите контакт  -> ");
        String number = scanner.next().toUpperCase(Locale.ROOT).trim();
        if (isNumber(number)) {
            int num = Integer.parseInt(number);
            if (num > 0 && num <= book.getPersonsList().size()) {
                return book.getPersonsList().get(num - 1);
            } else {
                System.out.print("Такой контакт не найден!");
            }
        } else {
            System.out.print("Не корректный ввод!");
        }
        return null;
    }

    private static void editingPerson(TelephoneBook book, Scanner scanner) {
        Person person = chosePerson(book, scanner);
        if (person != null) {
            System.out.println("Имя 1");
            System.out.println("Дата рождения 2");
            System.out.println("Телефоны 3");
            System.out.println("Адрес 4");
            String number = scanner.next().toUpperCase(Locale.ROOT).trim();
            if (isNumber(number)) {
                int num = Integer.parseInt(number);
                if (num > 0 && num < 5) {
                    switch (num) {
                        case 1 -> person.setName(getName(scanner));
                        case 2 -> person.setDateOfBirth(getDate(scanner));
                        case 3 -> person.setTelephones(getTelephones(scanner));
                        case 4 -> person.setAddress(getAddress(scanner));
                    }
                    System.out.println("Контакт успешно отредиктирован :)");
                } else {
                    System.out.print("Выбор не корректный!");
                }
            } else {
                System.out.print("Не корректный ввод!");
            }
        }
    }

    private static void deletePerson(TelephoneBook book, Scanner scanner) {
        Person person = chosePerson(book, scanner);
        if (person != null) {
            book.getPersonsList().remove(person);
            System.out.println("Успешно удален");
        }
    }

    private static void addPerson(TelephoneBook book, Scanner scanner) {
        String name = getName(scanner);
        LocalDate dateOfBirth = getDate(scanner);
        List<String> telephones = getTelephones(scanner);
        String address = getAddress(scanner);
        book.addPerson(new Person(name, dateOfBirth, telephones, address));
        System.out.println("Запись успешно добавлена :)");
    }

    private static String getName(Scanner scanner) {
        System.out.print("Введите имя -> ");
        return scanner.next().toUpperCase(Locale.ROOT).trim();
    }

    private static String getAddress(Scanner scanner) {
        System.out.print("Введите адресс -> ");
        return scanner.next().toUpperCase(Locale.ROOT).trim();
    }

    private static LocalDate getDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String regexp = "^\\d{4}/\\d{2}/\\d{2}$";
        String date;
        do {
            System.out.print("Введите дату рождения в формате (yyyy/MM/dd) -> ");
            date = scanner.next().toUpperCase(Locale.ROOT).trim();
            if (!date.matches(regexp)) {
                System.out.print("Введите дату рождения в формате (yyyy/MM/dd) -> ");
            }
        } while (!date.matches(regexp));
        return LocalDate.parse(date, formatter);
    }

    private static List<String> getTelephones(Scanner scanner) {
        String regexp = "^(?:\\+38)?(0\\d{9})$";
        List<String> telephones = new ArrayList<>();
        String telNumber;
        do {
            System.out.print("Введите номер телефона 0 для выхода ->");
            telNumber = scanner.next().toUpperCase(Locale.ROOT).trim();
            if (!telNumber.equals("0")) {
                if (telNumber.matches(regexp)) {
                    telephones.add(telNumber);
                } else {
                    System.out.println("Введите корректный номер телефона!");
                }
            }
        } while (!telNumber.equals("0"));
        return telephones;
    }

    private static void viewing(TelephoneBook book) {
        if (book.getPersonsList().size() > 0) {
            showPersonsList(book);
        } else {
            System.out.println("К сожалению список пока что пуст :(");
        }
    }
}
