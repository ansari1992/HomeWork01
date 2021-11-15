package com.pb.vasylenko.hw7;

public class Shirt extends Clothes implements ManClothes, WomenClothes {
    private final String shirtName;

    public Shirt() {
        super();
        this.shirtName = "default name";
    }

    public Shirt(String shirtName, Size size, String color, int price) {
        super(size, color, price);
        this.shirtName = shirtName;
    }

    @Override
    public void dressMan() {
        System.out.println("Name = " + this.shirtName);
        System.out.println("Size = " + super.getSize().getDescription() + ", euro size: " + super.getSize().getEuroSize());
        System.out.println("Color = " + super.getColor());
        System.out.println("Color = " + super.getPrice());
    }

    @Override
    public void dressWomen() {
        System.out.println("Name = " + this.shirtName);
        System.out.println("Size = " + super.getSize().getDescription() + ", euro size: " + super.getSize().getEuroSize());
        System.out.println("Color = " + super.getColor());
        System.out.println("Color = " + super.getPrice());
    }
}
