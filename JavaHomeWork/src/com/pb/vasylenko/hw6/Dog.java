package com.pb.vasylenko.hw6;

import java.util.Objects;

public class Dog extends Animal {
    private int tailLength;

    public Dog() {
        super();
        this.tailLength = 1;
    }

    public Dog(String food, String location, int tailLength) {
        super(food, location);
        this.tailLength = tailLength;
    }


    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public void setFood(String food) {
        super.setFood(food);
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
    }


    public int getTailLength() {
        return tailLength;
    }

    @Override
    public String getFood() {
        System.out.print("Dog with a long tail " + this.tailLength + " eating: ");
        return super.getFood();
    }

    @Override
    public String getLocation() {
        System.out.print("Dog with a long tail " + this.tailLength + " lives: ");
        return super.getLocation();
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void sleep() {
        super.sleep();
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "tailLength=" + tailLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return tailLength == dog.tailLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tailLength);
    }
}
