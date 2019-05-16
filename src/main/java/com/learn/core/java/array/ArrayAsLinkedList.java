package com.learn.core.java.array;

public class ArrayAsLinkedList {

    private int ax=5000;
    public static void main(String[] args) {
        int A[] = {1,4,-1,3,2};

       // System.out.println(solution1(8));
       // System.out.println(solution1(36));
        System.out.println(solution(8));
        System.out.println();
       // 1, 4, -1, 3, 2
    }

    public static int solution(int N){
        double value = fib(N);
        String str = String.format("%06.0f",value);
        if(str.length()>6){
            str = str.substring(str.length()-6);
        }
        return Integer.parseInt(str);
    }

    public static int solution1(int N){
        double value = fib(N);
        String str = String.format("%06x",value);
        /*if(str.length()>6){
            str = str.substring(str.length()-6);
        }*/
        return Integer.parseInt(str);
    }


    private static int fib(int n) {
        if(n<=1) {
            return  n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if(A == null || A.length == 0) {
            return 0;
        }
        int index = 0;
        int length=0;
        do {
            int value = A[index];
            if(value == -1){
                length++;
                break;
            }
            length++;
            index = value;
        }while (index<A.length);
        return length;
    }

    class B {
        B(){
            System.out.println(ax);
        }
    }
}



