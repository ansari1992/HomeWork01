package com.pb.vasylenko.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    private final String pantsName;

    public Pants() {
        super();
        this.pantsName = "default name";
    }

    public Pants(String pantsName, Size size, String color, int price) {
        super(size, color, price);
        this.pantsName = pantsName;
    }

    @Override
    public void dressMan() {
        System.out.println("Name = " + this.pantsName);
        System.out.println("Size = " + super.getSize().getDescription() + ", euro size: " + super.getSize().getEuroSize());
        System.out.println("Color = " + super.getColor());
        System.out.println("Color = " + super.getPrice());
    }

    @Override
    public void dressWomen() {
        System.out.println("Name = " + this.pantsName);
        System.out.println("Size = " + super.getSize().getDescription() + ", euro size: " + super.getSize().getEuroSize());
        System.out.println("Color = " + super.getColor());
        System.out.println("Color = " + super.getPrice());
    }
}
