package com.pb.vasylenko.hw6;

import java.util.Objects;

public class Horse extends Animal {
    private int hoofDiameter;

    public Horse() {
        super();
        this.hoofDiameter = 1;
    }

    public Horse(String food, String location, int hoofDiameter) {
        super(food, location);
        this.hoofDiameter = hoofDiameter;
    }

    public void setHoofDiameter(int hoofDiameter) {
        this.hoofDiameter = hoofDiameter;
    }

    @Override
    public void setFood(String food) {
        super.setFood(food);
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
    }

    public int getHoofDiameter() {
        return hoofDiameter;
    }

    @Override
    public String getFood() {
        System.out.print("Horse with a hoof diameter " + this.hoofDiameter + " eating: ");
        return super.getFood();
    }

    @Override
    public String getLocation() {
        System.out.print("Horse with a hoof diameter " + this.hoofDiameter + " lives: ");
        return super.getLocation();
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
    }

    @Override
    public void sleep() {
        super.sleep();
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public String toString() {
        return "Horse{" +
                "hoofDiameter=" + hoofDiameter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return hoofDiameter == horse.hoofDiameter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoofDiameter);
    }
}
