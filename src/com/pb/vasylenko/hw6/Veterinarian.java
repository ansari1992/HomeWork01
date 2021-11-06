package com.pb.vasylenko.hw6;

import java.util.Objects;

public class Veterinarian {
    private String veterinarianName;

    public Veterinarian() {
        this.veterinarianName = "Vanja";
    }

    public Veterinarian(String veterinarianName) {
        this.veterinarianName = veterinarianName;
    }

    public void setVeterinarianName(String veterinarianName) {
        this.veterinarianName = veterinarianName;
    }

    public String getVeterinarianName() {
        return veterinarianName;
    }

    public void treatAnimal(Animal animal) {
        System.out.println("A veterinarian named " + this.veterinarianName + " adopted such an animal:");
        System.out.println(animal.getFood());
        System.out.println(animal.getLocation());
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "veterinarianName='" + veterinarianName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veterinarian that = (Veterinarian) o;
        return Objects.equals(veterinarianName, that.veterinarianName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(veterinarianName);
    }
}
