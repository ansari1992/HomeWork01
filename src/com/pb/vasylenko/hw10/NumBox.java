package com.pb.vasylenko.hw10;

import java.lang.reflect.Array;

public class NumBox<T extends Number> {
    private final T[] array;

    public NumBox(Class<T> clazz, int capacity) {
        this.array = (T[]) Array.newInstance(clazz, capacity);
    }

    public Number[] getArray() {
        return this.array;
    }

    public void add(T num) throws Exception {
        boolean isFull = false;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == null) {
                isFull = false;
                this.array[i] = num;
                break;
            } else {
                isFull = true;
            }
        }
        if (isFull) throw new Exception("FullArrayException!");
    }

    public T get(int index) throws Exception {
        if (index > this.array.length || index < 0) throw new Exception("Bad index!");
        return this.array[index];
    }

    public int length() {
        int count = 0;
        for (T t : this.array) {
            if (t != null) count++;
            break;
        }
        return count;
    }

    public double average() {
        double sum = 0D;
        int count = 0;
        for (T t : this.array) {
            if (t != null) {
                sum += t.doubleValue();
                count++;
            } else {
                break;
            }
        }
        return sum / count;
    }

    public double sum() {
        double sum = 0D;
        for (T t : this.array) {
            if (t != null) {
                sum += t.doubleValue();
            } else {
                break;
            }
        }
        return sum;
    }
}
