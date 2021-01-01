package com.learn.core.java.meetansh.learning;

import java.util.Scanner;

public class BillMaker {

    public static void main(String[] s) {
        System.out.println("Your bill is as below");

        String[] items =  {"Tshirt", "Pencil", "Book", "Car", "Vegetables"};
        int[] units =  {10, 5, 3, 4, 3};

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Items           Unit            Cost                Price");
        System.out.println("----------------------------------------------------------------------");

        for(String item : items){
            System.out.println(item);
        }

        for(int unit : units){
            System.out.println(unit);
        }

        System.out.println("----------------------------------------------------------------------");

        System.out.println("----------------------------------------------------------------------");


    }
}