package com.learn.core.java.hackerrank;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.function.Function;


/**
 * How to modify the same program to support train with large no. of wagons with same memory.
 */
public class Train {
    private LinkedList<Integer> wagons;

    public Train(int wagonCount, Function<Integer, Integer> fillWagon) {
        this.wagons = new LinkedList<>();

        for (int i = 0; i < wagonCount; i++) {
            this.wagons.add(i, fillWagon.apply(i));
        }
    }

    public int peekWagon(int wagonIndex) {
        return this.wagons.get(wagonIndex);
    }

    public static void main(String[] args) {
        Train train = new Train(10, wagonIndex -> wagonIndex);

        for (int i = 0; i < 10; i++) {
            System.out.println("Wagon: " + i + ", cargo: " + train.peekWagon(i));
        }
    }
}