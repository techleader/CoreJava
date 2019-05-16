package com.learn.core.java.string;

public class FibboacciManipulation {

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
        String str = String.format("Acutal result  : " + value);
        System.out.println(str);
        str = String.format("%06.0f",value);
        System.out.println(str);
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
}
