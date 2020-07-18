package com.learn.core.java.rajesh;

import java.util.Scanner;

public class Interger {

    static void findMax(){
        int a=-10,b=-5;
        if(a>b){
            System.out.println(a);
        }else{
            System.out.println(b);
        }
    }

    public static void main(String[] args) {

        findMax();
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();

        if(n%2==0){
            if(n>=2&n<5){
                System.out.println("not weird");

            }
            if(n>=6&n<=20){
                System.out.println("weird");

            }
            if(n>=20){
                System.out.println("not weird");

            }
        } else{
            System.out.println("weird");
        }


       /* byte bt = 1;
        System.out.println(bt);

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        System.out.println(min);
        System.out.println(max);
        System.out.println(-min);
        System.out.println(-max);

        max = Integer.MAX_VALUE+1;
        System.out.println(max);

        min = Integer.MIN_VALUE - 1;
        System.out.println(min);*/
    }
}
