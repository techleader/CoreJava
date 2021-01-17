package com.learn.core.java.sort;

import static com.learn.core.java.sort.SortUtils.*;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = { 10, 30, 80, 90, 40,50,70 };
		System.out.println("Given Array");
		printArray(arr);		
		QuickSortArray.sort(arr);
		System.out.println("\nSorted array");
		printArray(arr);
	}

	static class QuickSortArray {

		public static void sort(int[] arr) {
			sort(arr, 0, arr.length-1);
		}

		public static void sort(int[] arr, int low, int high) {
			if(low>=high) return;
			int pivotIndex = partition(arr,low, high);			
			sort(arr,low,pivotIndex-1);
			sort(arr,pivotIndex+1,high);
		}
		
		public static int partition(int[] arr, int low, int high) {
			System.out.println("partition");
			printArray(arr);
			int index = low;	
			if(low==high) return high;
			for(int j=low; j<high ; j++) {
				if( arr[j] <= arr[high]) {
					swap(arr,index,j);
					index++;
				}
				printArray(arr);
			}
			swap(arr,index, high);	
			System.out.println("partition 3 :" + index) ;
			printArray(arr);
			return index;
		}
	}

}
