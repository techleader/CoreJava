package com.learn.core.java.skillenza;

import java.util.Scanner;

public class PiramidProblem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer tests = Integer.parseInt(scan.nextLine());
        if (tests < 1 || tests > 256) {
            System.out.println("existing as tests no in range");
            return;
        }
        String[] lines = new String[tests];

        for (int i = 0; i < tests; i++) {
            lines[i] = scan.nextLine();
        }

        for (int i = 0; i < tests; i++) {
            String line = lines[i];
            String[] lineEle = line.split(" ");
            String string = lineEle[0];
            int height = Integer.parseInt(lineEle[1]);
            int direction = Integer.parseInt(lineEle[2]);
            if (string.length() > 16) {
                System.out.println("existing as string no in range");
                return;
            }
            if (height < 1 || height > 128) {
                System.out.println("existing as height no in range");
                return;
            }
            if (!(direction == 1 || direction == -1)) {
                System.out.println("existing as direction no in range");
                return;
            }
            if (direction == 1 || direction == -1) {
                printPyramid(string, height, direction);
            }
        }
    }

    private static void printPyramid(String string, int height, int direction) {
        StringTokenizer tokenizer = new StringTokenizer(string);
        boolean leftToRight = true;
        for (int i = 1; i <= height; i++) {
            int items = (direction == 1) ? i : height + 1 - i;
            int noOfItems = items * 2 - 1;
            int noOfSpace = height - items;

            try {
                System.out.print(String.format("%" + noOfSpace + "s", ""));
            } catch (Exception e) {
            }

            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < noOfItems; j++) {
                if (leftToRight) {
                    buffer.append(tokenizer.next());
                } else {
                    buffer.insert(0, tokenizer.next());
                }
            }
            leftToRight = !leftToRight;
            System.out.println(buffer.toString());
        }

    }


    static class StringTokenizer {
        private String value;
        private int index = 0;

        StringTokenizer(String value) {
            this.value = value;
        }

        public Character next() {
            Character c = value.charAt(index++);
            if (index >= value.length()) {
                index = 0;
            }
            return c;
        }

    }

}
