package com.pb.vasylenko.hw6;

import java.util.ArrayList;

public class VetClinic {

    public static void main(String[] args) {
        Cat myCat = new Cat("cat food", "Ukraine", 1);
        Dog myDog = new Dog("meat", "Ukraine", 2);
        Horse myHorse = new Horse("hay", "Ukraine", 3);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(myDog);
        animals.add(myCat);
        animals.add(myHorse);
        try {
            Veterinarian veterinarian = (Veterinarian) Class.forName(Veterinarian.class.getName()).getConstructor().newInstance();
            for (Animal animal : animals) {
                veterinarian.treatAnimal(animal);
            }
        } catch (Exception exception) {
            System.out.println("We apologize, but there will be no kin :)");
        }
    }
}
