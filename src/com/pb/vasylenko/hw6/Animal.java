package com.pb.vasylenko.hw6;

public class Animal {
    private String food;
    private String location;

    public Animal() {
        this.food = "unknown food";
        this.location = "unknown habitat";
    }

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {
        System.out.println("makes a sound");
    }

    public void eat() {
        System.out.println("eating");
    }

    public void sleep() {
        System.out.println("is sleeping");
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
}
