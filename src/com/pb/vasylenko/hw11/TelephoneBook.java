package com.pb.vasylenko.hw11;

import java.io.*;
import java.util.*;

public class TelephoneBook {

    private List<Person> personsList;

    public TelephoneBook() {
        this.personsList = new ArrayList<>();
    }

    public TelephoneBook(List<Person> persons) {
        this.personsList = persons;
    }

    public void setPersonsList(List<Person> personsList) {
        this.personsList = personsList;
    }

    public List<Person> getPersonsList() {
        return this.personsList;
    }

    public void addPerson(Person person) {
        this.personsList.add(person);
    }

    public void removePerson(Person person) {
        this.personsList.remove(person);
    }

    public Comparator<Person> sortBy(int sortParameter) {
        if (this.personsList.size() > 0) {
            Comparator<Person> comparator = null;
            switch (sortParameter) {
                case 1 -> {
                    comparator = (o1, o2) -> CharSequence.compare(o1.getName(), o2.getName());
                }
                case 2 -> {
                    comparator = Comparator.comparing(Person::getDateOfBirth);
                }
                case 3 -> {
                    comparator = Comparator.comparingInt(o -> o.getTelephones().size());
                }
                case 4 -> {
                    comparator = (o1, o2) -> CharSequence.compare(o1.getAddress(), o2.getAddress());
                }
                case 5 -> {
                    comparator = Comparator.comparing(Person::getDateOfEditing);
                }
            }
            return comparator;
        }
        return null;
    }

    public boolean toFile() {
        boolean isSuccess;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("telephoneBook.out"));
            objectOutputStream.writeObject(this.personsList);
            objectOutputStream.close();
            isSuccess = true;
        } catch (Exception var3) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public boolean fromFile() {
        boolean isSuccess;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("telephoneBook.out"));
            this.personsList = (List<Person>) objectInputStream.readObject();
            objectInputStream.close();
            isSuccess = true;
        } catch (Exception var3) {
            isSuccess = false;
        }
        return isSuccess;
    }
}

