package com.learn.core.java.sort;

/* Java program for Merge Sort */
class MergeSortImproved
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
		/* Create temp arrays */
        int Aux[] = new int [arr.length];

		/*Copy data to temp arrays*/
        for (int i=l; i<=r; i++)
            Aux[i] = arr[i];

        int i = l, j = m+1;
        for ( int k=l;k <= r ; k ++)
        {
            if(i> m) arr[k] = Aux[j++];
            else if (j> r) arr[k] = Aux[i++];
            else if (Aux[j] < Aux[i]) arr[k] = Aux[j++];
            else arr[k] = Aux[i++];
        }

    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7,50};

        System.out.println("Given Array");
        printArray(arr);

        MergeSortImproved ob = new MergeSortImproved();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
}
/* This code is contributed by Rajat Mishra */
