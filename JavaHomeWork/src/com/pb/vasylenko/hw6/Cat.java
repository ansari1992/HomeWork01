package com.pb.vasylenko.hw6;

import java.util.Objects;

public class Cat extends Animal {
    private int mustacheLength;

    public Cat() {
        super();
        this.mustacheLength = 1;
    }

    public Cat(String food, String location, int mustacheLength) {
        super(food, location);
        this.mustacheLength = mustacheLength;
    }

    public void setMustacheLength(int mustacheLength) {
        this.mustacheLength = mustacheLength;
    }

    @Override
    public void setFood(String food) {
        super.setFood(food);
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
    }

    public int getMustacheLength() {
        return mustacheLength;
    }

    @Override
    public String getFood() {
        System.out.print("Cat with a mustache length " + this.mustacheLength + " eating: ");
        return super.getFood();
    }

    @Override
    public String getLocation() {
        System.out.print("Cat with a mustache length " + this.mustacheLength + " lives: ");
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
        return "Cat{" +
                "mustacheLength=" + mustacheLength +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return mustacheLength == cat.mustacheLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mustacheLength);
    }
}