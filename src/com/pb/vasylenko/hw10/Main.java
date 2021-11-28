package com.pb.vasylenko.hw10;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        NumBox<Float> floats = new NumBox<>(Float.class, 3);
        Float flOne = 5F;
        Float flTwo = 7.5F;
        Float flThree = 7F;
        floats.add(flOne);
        floats.add(flTwo);
        floats.add(flThree);
        System.out.println("Array is: " + Arrays.toString(floats.getArray()));
        System.out.println("Max: " + floats.max());
        System.out.println("Length: " + floats.length());
        System.out.println("Get: " + floats.get(2));
        System.out.println("AVG: " + floats.average());
        System.out.println("SUM: " + floats.sum());

        NumBox<Integer> integerNumBox = new NumBox<>(Integer.class,3);
        Integer intOne = 1;
        Integer intTwo = 2;
        Integer intThree = 4;
        integerNumBox.add(intOne);
        integerNumBox.add(intTwo);
        integerNumBox.add(intThree);
        System.out.println("Array is: " + Arrays.toString(integerNumBox.getArray()));
        System.out.println("Max: " + integerNumBox.max());
        System.out.println("Length: " + integerNumBox.length());
        System.out.println("Get: " + integerNumBox.get(2));
        System.out.println("AVG: " + integerNumBox.average());
        System.out.println("SUM: " + integerNumBox.sum());
    }
}