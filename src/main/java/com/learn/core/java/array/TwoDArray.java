package com.learn.core.java.array;

import java.util.Scanner;

/**
 * Created by Meetansh on 18-07-2016.
 */
public class TwoDArray {

    public static int sum(int[][] a,int i,int j)
    {
        int sum;
        sum = a[i][j] + a[i][j+1] + a[i][j+2] + a[i+1][j+1] +a[i+2][j] + a[i+2][j+1] + a[i+2][j+2];
        return sum;
    }

    public static void main(String[] args) {
        int a[][] = new int[6][6];
        Scanner s = new Scanner(System.in);
        int max = -10000;
        int output=0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                a[i][j] = s.nextInt();
            }
            s.nextLine();
        }

        for (int i=0;i<3;i++)
        {
            for(int j =0 ;j<3;j++) {

                output = sum(a,i,j);

            }

        }
        System.out.println(output);
    }

}