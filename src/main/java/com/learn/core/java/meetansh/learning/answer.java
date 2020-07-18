package com.learn.core.java.meetansh.learning;

        import java.util.Scanner;

public class answer {

    public static void main(String[] s) {

        System.out.println("What is the capital of india");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int total_marks = 0;
        if (name.equals("delhi")) {
            System.out.println("You are great");
            total_marks = total_marks+1;
        } else {
            System.out.println("Wrong answer");
        }
        System.out.println("What is the capital of rajeshthan");
        name = scan.nextLine();
        if (name.equals("jaipur")) {
            System.out.println("You are great");
            total_marks = total_marks + 1;

        } else {
            System.out.println("Wrong answer");

        }
        System.out.println("Who proved that Sun is in the middle of the Solar system");
        name = scan.nextLine();

        if (name.equals("nicolaus copernicus")) {
            total_marks = total_marks + 1;
            System.out.println("You are great");

        } else {
            System.out.println("Wrong answer. Correct answer is " + name);
        }

        System.out.println("how much actual time does earth takes to complete its rotation");
        name = scan.nextLine();

        if (  name.equals("23h 56m 4s")   ) {
            System.out.println("you are great");
            total_marks = total_marks + 1;
        } else {
            System.out.println("wrong answer. correct answer is + name ");
        }
        System.out.println("total marks you secured :" + total_marks);
        if (total_marks < 2 ) {
            System.out.println("sorry you are fail");

        }

    }

}

