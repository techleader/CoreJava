package com.learn.core.java.meetansh.learning;

import java.util.Scanner;

public class GameWinner {
    public static void main (String[] s){    	

        System.out.println("Enter the score of India team");
        Scanner scan = new Scanner(System.in);
        int indiat = scan.nextInt();
        System.out.println("Enter the score of Pakisthan team");
        int pakis = scan.nextInt();
        if (indiat > pakis) {
            System.out.println("India is amazing  india is the winner");

        }
        if (pakis > indiat) {
            System.out.println("Pakistan is good  pakistan is the winner");

        }

    }

}
