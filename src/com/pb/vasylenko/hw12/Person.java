package com.pb.vasylenko.hw12;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {
    private String name;
    private LocalDate dateOfBirth;
    private List<String> telephones;
    private String address;
    private String dateOfEditing;

    public Person(String name, LocalDate dateOfBirth, List<String> telephones, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.telephones = telephones;
        this.address = address;
        setDateOfEditing();
    }

    private void setDateOfEditing() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        this.dateOfEditing = dateFormat.format(cal.getTime());
    }

    public void setName(String name) {
        this.name = name;
        setDateOfEditing();
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        setDateOfEditing();
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
        setDateOfEditing();
    }

    public void setAddress(String address) {
        this.address = address;
        setDateOfEditing();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public List<String> getTelephones() {
        return telephones;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfEditing() {
        return dateOfEditing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(telephones, person.telephones) && Objects.equals(address, person.address) && Objects.equals(dateOfEditing, person.dateOfEditing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfBirth, telephones, address, dateOfEditing);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", telephones=" + telephones +
                ", address='" + address + '\'' +
                ", dateOfEditing='" + dateOfEditing + '\'' +
                '}';
    }
}
