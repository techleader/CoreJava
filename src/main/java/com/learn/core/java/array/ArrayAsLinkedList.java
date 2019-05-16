package com.learn.core.java.array;

public class ArrayAsLinkedList {


    public static void main(String[] args) {
        int A[] = {1,4,-1,2,3};
        System.out.println("\nTotal len : " +solution(A));
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
                break;
            } else {
                System.out.print(index + "(" + value + ") ->");
            }

            length++;
            index = value;
        }while (index<A.length);
        return length;
    }
}



