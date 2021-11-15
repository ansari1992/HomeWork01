package com.pb.vasylenko.hw7;

public class Atelier {

    public static void main(String[] args) {
        Tie tie = new Tie("man tie", Size.L, "red", 20);
        Skirt skirt = new Skirt("woman skirt", Size.L, "blue", 34);
        Shirt shirt = new Shirt("shirt", Size.S, "black", 30);
        Pants pants = new Pants("pants", Size.XXS, "white", 37);
        Clothes[] clothes = new Clothes[]{tie, skirt, shirt, pants};
        System.out.println("Dress man");
        Atelier.dressMan(clothes);
        System.out.println("Dress woman");
        Atelier.dressWomen(clothes);
    }

    public static void dressMan(Clothes[] clothes) {
        for (Clothes cl : clothes) {
            if (cl instanceof Shirt || cl instanceof Pants || cl instanceof Tie) {
                cl.dressMan();
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        for (Clothes cl : clothes) {
            if (cl instanceof Shirt || cl instanceof Pants || cl instanceof Skirt) {
                cl.dressMan();
            }
        }
    }
}
