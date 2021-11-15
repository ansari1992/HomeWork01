package com.pb.vasylenko.hw7;

public class Skirt extends Clothes implements ManClothes, WomenClothes {
    private final String skirtName;

    public Skirt() {
        super();
        this.skirtName = "default name";
    }

    public Skirt(String skirtName, Size size, String color, int price) {
        super(size, color, price);
        this.skirtName = skirtName;
    }

    @Override
    public void dressMan() {
        System.out.println("Name = " + this.skirtName);
        System.out.println("Size = " + super.getSize().getDescription() + ", euro size: " + super.getSize().getEuroSize());
        System.out.println("Color = " + super.getColor());
        System.out.println("Color = " + super.getPrice());
    }

    @Override
    public void dressWomen() {
        System.out.println("Name = " + this.skirtName);
        System.out.println("Size = " + super.getSize().getDescription() + ", euro size: " + super.getSize().getEuroSize());
        System.out.println("Color = " + super.getColor());
        System.out.println("Color = " + super.getPrice());
    }
}
