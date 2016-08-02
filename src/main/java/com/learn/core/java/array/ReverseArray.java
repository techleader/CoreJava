package com.learn.core.java.array;

import java.util.Scanner;

/**
 * Created by Meetansh on 18-07-2016.
 */
public class ReverseArray {
    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] ={1,2,3,4,5};
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int temp;
        for(int i=0;i<n-1;i++){
            temp=arr[0];
            for(int j=0;j<n-1-i ;j++){

                arr[j]=arr[j+1];

            }
            arr[n-i-1]=temp;
        }

         temp=arr[arr.length-1];
        for(int j=arr.length-1;j>0 ;j--){

            arr[j]=arr[j-1];

        }
        arr[0]=temp;
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
