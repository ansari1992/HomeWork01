package com.pb.vasylenko.hw7;

public class Tie extends Clothes implements ManClothes, WomenClothes {
    private final String tieName;

    public Tie() {
        super();
        this.tieName = "default name";
    }

    public Tie(String tieName, Size size, String color, int price) {
        super(size, color, price);
        this.tieName = tieName;
    }

    @Override
    public void dressMan() {
        System.out.println("Name = " + this.tieName);
        System.out.println("Size = " + super.getSize().getDescription() + ", euro size: " + super.getSize().getEuroSize());
        System.out.println("Color = " + super.getColor());
        System.out.println("Color = " + super.getPrice());
    }

    @Override
    public void dressWomen() {
        System.out.println("Name = " + this.tieName);
        System.out.println("Size = " + super.getSize().getDescription() + ", euro size: " + super.getSize().getEuroSize());
        System.out.println("Color = " + super.getColor());
        System.out.println("Color = " + super.getPrice());
    }
}
