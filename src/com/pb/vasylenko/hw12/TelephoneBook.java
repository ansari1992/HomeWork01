package com.pb.vasylenko.hw12;

import com.pb.vasylenko.hw11.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TelephoneBook {

    private List<com.pb.vasylenko.hw11.Person> personsList;

    public TelephoneBook() {
        this.personsList = new ArrayList<>();
    }

    public TelephoneBook(List<com.pb.vasylenko.hw11.Person> persons) {
        this.personsList = persons;
    }

    public void setPersonsList(List<com.pb.vasylenko.hw11.Person> personsList) {
        this.personsList = personsList;
    }

    public List<com.pb.vasylenko.hw11.Person> getPersonsList() {
        return this.personsList;
    }

    public void addPerson(com.pb.vasylenko.hw11.Person person) {
        this.personsList.add(person);
    }

    public void removePerson(com.pb.vasylenko.hw11.Person person) {
        this.personsList.remove(person);
    }

    public Comparator<com.pb.vasylenko.hw11.Person> sortBy(int sortParameter) {
        if (this.personsList.size() > 0) {
            Comparator<com.pb.vasylenko.hw11.Person> comparator = null;
            switch (sortParameter) {
                case 1 -> {
                    comparator = (o1, o2) -> CharSequence.compare(o1.getName(), o2.getName());
                }
                case 2 -> {
                    comparator = Comparator.comparing(com.pb.vasylenko.hw11.Person::getDateOfBirth);
                }
                case 3 -> {
                    comparator = Comparator.comparingInt(o -> o.getTelephones().size());
                }
                case 4 -> {
                    comparator = (o1, o2) -> CharSequence.compare(o1.getAddress(), o2.getAddress());
                }
                case 5 -> {
                    comparator = Comparator.comparing(com.pb.vasylenko.hw11.Person::getDateOfEditing);
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

