package com.learn.core.java.sort;

/**
 * Created by Meetansh on 16-07-2016.
 */
public class SelectionSort {
    public static void main(String arg[]) {
        int i, j, temp;
        int a[] = {2, 4, 3, 1, 5,10,6,9,8,7};

        for (i = 0; i < a.length-1; i++) {
            for (j = i; j < a.length-1; j++) {
                if (a[i] >a[j + 1]) {
                    temp = a[i];
                    a[i] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
