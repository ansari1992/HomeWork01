package com.pb.vasylenko.hw7;

public abstract class Clothes implements ManClothes, WomenClothes{
    private final Size size;
    private final String color;
    private final int price;

    public Clothes() {
        this.size = Size.XXS;
        this.color = "default color";
        this.price = 0;
    }

    public Clothes(Size size, String color, int price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }
}
