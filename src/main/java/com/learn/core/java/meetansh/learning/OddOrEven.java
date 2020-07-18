package com.learn.core.java.meetansh.learning;

import java.util.Scanner;

public class OddOrEven {

    public static void main(String[] s) {

        String con = "yes";
        do {


            System.out.println("Please enter any number");
            Scanner scan = new Scanner(System.in);
            int no = scan.nextInt();
            if (no < 0) {
                System.out.println("This is negetive number");

            }
            if (no >= 0) {
                System.out.print("This is positive number");

            }

            int reminder = no % 2;
            int quo = no / 2;

            System.out.println("value of quo is : " + quo);
            System.out.println("value of reminder is : " + reminder);
            if (reminder == 0) {
                System.out.println("This is an even no.");
            }
            if (reminder != 0) {
                System.out.println("This is an odd no.");
            }
            System.out.println("...........................");

            System.out.println("Do you want to continue - yes/no?");
            scan.nextLine();
            con = scan.nextLine();

        } while(con.equals("yes") );
    }


}
