package com.learn.core.java.sort;

import java.util.Arrays;

/**
 * Created by Admin on 08-07-2016.
 */
public class SortUtils {

    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr,int beginIndex, int n){
        int i, key, j;
        for (i = 1; i < n; i++)
        {
            key = arr[i];
            j = i-1;

       /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    public static void mergeSort(int[] array){
        if(array==null || array.length==0) return;
        mergeSort(array,0,array.length);
    }

    private static void mergeSort(int[] array,int startIndex, int len){
        if(len>1){
            int dividePoint = len/2;
            mergeSort(array,startIndex,dividePoint);
            mergeSort(array,startIndex + dividePoint,len-dividePoint);
            combile(array,startIndex,dividePoint,startIndex + dividePoint,len-dividePoint);
        }
    }
    private static void combile(int[] array,int a1i,int a1l, int a2i,int a2l){
        insertionSort(array,a1i,a1l+a2l);
    }




    public static void main(String... s){
        int a[] ={5,14,3,22,1};
        mergeSort(a);
        Arrays.stream(a).forEach(System.out::print);
    }

}









































































