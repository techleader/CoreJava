package com.learn.core.java.meetansh.learning;

import java.util.Scanner;

public class MarksTotal {

    public static void main(String[] s){

        System.out.println("Enter Meetansh's  math, eng, sci marks");
        Scanner scan = new Scanner(System.in);
        int meetsnshmath = scan.nextInt();
        int meetsnshsci = scan.nextInt();
        int meetanshenglish = scan.nextInt();
        System.out.println("Enter Snidhaya  math eng sci marks");
        int sanmath = scan.nextInt();
        int sansci = scan.nextInt();
        int sanenglish = scan.nextInt();

        int totalmeet = meetsnshmath + meetanshenglish + meetsnshsci;
        int totalsan = sanmath + sanenglish + sansci;

        System.out.println("Meetansh total no: " + totalmeet);
        System.out.println("Sanidhya total no: " + totalsan);

        if(totalmeet > totalsan) {
            System.out.println("Meetansh is topper");
        }
        if(totalmeet < totalsan) {
            System.out.println("Sanidhya is topper");
        }

    }

}
