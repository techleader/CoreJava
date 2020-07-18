package com.learn.core.java.meetansh.learning;

import java.util.Scanner;

public class FirstClass {

    public static void main(String[] s){
        System.out.println("Enter your Name");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("Hello " + name + " :)");
        System.out.println("Enter your age");
        int age = scan.nextInt();
        if(age < 18){
            System.out.println("You are age "+ age + " year old child.... great. Welcome to the Java Game");
        }
        if(age >= 18){
            System.out.println("You are "+ age + " year old elder.... great. Welcome to the Java Game");
        }
        System.out.println("Enter your english mask");
        int marks1 = scan.nextInt();

        System.out.println("Enter your math mask");

        int marks2 = scan.nextInt();
        System.out.println("Enter your science mask");

        int marks3 = scan.nextInt();

        int total = marks1 + marks2 + marks3;

        System.out.println("total marks are " + total);

        if(total >= 90){
            System.out.print("You are pass");
        }
        if(total < 90){
            System.out.print("You are fail");
        }

    }

}
