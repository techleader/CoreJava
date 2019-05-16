package com.learn.core.java.hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * Created by Meetansh on 16-03-2017.
 */
public class CandyReplenishingRobot {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int t = in.nextInt();
            int[] c = new int[t];
            for(int c_i=0; c_i < t; c_i++){
                c[c_i] = in.nextInt();
            }

            int remaining = n;
            int totaladded = 0;
            for(int c_i = 0; c_i < t; c_i ++){
                if(remaining <5) {
                    int add = n-remaining;
                    remaining += add;
                    totaladded +=add;

                }
                remaining = remaining - c[c_i];
            }
            System.out.println(totaladded);
            // your code goes here
        }
    }
