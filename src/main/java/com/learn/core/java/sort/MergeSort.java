package com.learn.core.java.sort;


/* Java program for Merge Sort */
public class MergeSort {
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]

	public static void main(String args[]) {
		int arr[] = { 12, 7, 5, 78, 65 };
		System.out.println("Given Array");
		SortUtils.printArray(arr);		
		MergeSort.MergeSortArray ob = new MergeSort.MergeSortArray();
		ob.sort(arr);
		System.out.println("\nSorted array");
		SortUtils.printArray(arr);
	}

	static class MergeSortArray {

		void sort(int arr[]) {
			int[] aux = new int[arr.length];
			sort(arr, aux, 0, arr.length - 1);
		}

		void sort(int arr[], int aux[], int lo, int hi) {
			if (lo >= hi)
				return;
			int mid = (lo + hi) / 2;
			System.out.println("" + lo + "=> " + mid + " => " + hi);
			sort(arr, aux, lo, mid);
			sort(arr, aux, mid + 1, hi);
			merge(arr, aux, lo, mid, hi);
		}

		void merge(int arr[], int[] aux, int lo, int mid, int hi) {

			for (int i = lo; i <= hi; i++)
				aux[i] = arr[i];
			int i = lo, j = mid + 1;
			for (int k = lo; k <= hi; k++) {
				if (i > mid)
					arr[k] = aux[j++];
				else if (j > hi)
					arr[k] = aux[i++];
				else if (aux[i] <= aux[j])
					arr[k] = aux[i++];
				else
					arr[k] = aux[j++];
			}
		}
	}


}
