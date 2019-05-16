package com.learn.core.java.hackerrank;

/**
 * Created by Meetansh on 16-03-2017.
 */

import java.util.Scanner;

/**
 * Jessica is learning to code and was recently introduced to the  function. This function compares two integers and returns the smaller one. This is what calling the function looks like when comparing two integers  and :

 min(a, b)
 Jessica realizes that she can also find the smallest of three integers , , and  if she puts the  function inside of another  function:

 min(a, min(b, c))
 For four integers she can nest the functions once more:

 min(a, min(b, min(c, d)))
 */
public class MinFunction {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getString(n));


    }

    public static String getString(int n){
        if(n == 2 )  return "min(int, int)";
        else
        return "min(int, "+ getString(n-1)+")";
    }
}
