package com.learn.core.java.meetansh.learning;

import java.util.Scanner;

public abstract class Tables {


     Thread ti =new Thread();


    public static void main(String[] s) {
        System.out.println("Enter any number");
        Scanner scan = new Scanner(System.in);
        int no = scan.nextInt();
        System.out.println("You need table of - " + no);
        System.out.println("--------------------");
        System.out.println(no * 1);
        System.out.println(no * 2);
        System.out.println(no * 3);
        System.out.println(no * 4);
        System.out.println(no * 5);
        System.out.println(no * 6);
        System.out.println(no * 7);
        System.out.println(no * 8);
        System.out.println(no * 9);
        System.out.println(no * 10);



    }

}
