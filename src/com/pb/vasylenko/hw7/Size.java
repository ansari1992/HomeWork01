package com.pb.vasylenko.hw7;

public enum Size {
    XXS("Child size", 32),
    XS("Adult size", 34),
    S("Adult size", 36),
    M("Adult size", 38),
    L("Adult size", 40);

    private final String size;
    private final int euroSize;

    Size(String size, int euroSize) {
        this.size = size;
        this.euroSize = euroSize;
    }

    public String getDescription() {
        return this.size;
    }

    public int getEuroSize() {
        return this.euroSize;
    }
}
