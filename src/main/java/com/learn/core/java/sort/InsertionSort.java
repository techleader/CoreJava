package com.learn.core.java.sort;

import java.util.Scanner;

/**
 * Created by Meetansh on 11-07-2016.
 */
public class InsertionSort {
    public static void main(String... s) {
        int temp1,temp2,n;
        int a[] ={};



        for (int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1]){
                temp1=a[i];
                a[i]=a[i+1];
                a[i+1]=temp1;
                if(i>0){
                    for (n=i;n>0;n--){
                        if(a[n]<a[n-1]) {
                            temp2 = a[n];
                            a[n] = a[n - 1];
                            a[n + -1] = temp2;
                        }
                    }

                }
            }

        }
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }

        }
}
