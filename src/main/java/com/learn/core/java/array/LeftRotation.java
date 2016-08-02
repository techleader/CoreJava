package com.learn.core.java.array;

import java.util.Scanner;

/**
 * Created by Meetansh on 20-07-2016.
 */
public class LeftRotation {

    public static void main(String[] args) {
        //Scanner s=new Scanner(System.in);
        int n=5;
        int r = 4;
        int a[] = {1,2,3,4,5};
        int temp;
        for(int i=0;i<r;i++){
            temp=a[0];
            for(int j=0;j<n-1;j++){
                a[j]=a[j+1];
            }
            a[n-1]=temp;
        }
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }

}
