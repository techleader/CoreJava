package com.learn.core.java.tree;

import java.util.LinkedList;

/**
 * Created by Meetansh on 11-07-2016.
 */
public class StringS {


    static int getCount(int[] A, int S) {
        int [] coins= new int[S+1];
        coins[0]=0;

        for(int i=1;i<coins.length;i++)
            coins[i]=Integer.MAX_VALUE;

        for(int i=1;i<=S;i++)
            for(int j=0;j<A.length;j++)
                if((A[j]<=i) && (coins[i-A[j]]+1<coins[i]))
                    coins[i]=coins[i-A[j]]+1;

        return coins[S];

    }

    public static void main(StringS... s){
        int c[] ={4,5,3,8,3,7};
        System.out.println(minArray(c));
    }

    int min;
    static int minArray(int[] arr) {
        if(arr==null || arr.length==0) {
            return 0;
        }
        LinkedList<Integer> allowed = new LinkedList<>();
        int min=arr[0];
        allowed.add(arr[0]);
        int maxAllowed=min*2;
        int itemsToBeRemoved = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
                maxAllowed = min*2;
                itemsToBeRemoved+= removeNotAllowed(allowed,maxAllowed);
            }
            if (arr[i]>maxAllowed){
                itemsToBeRemoved++;
            } else {
                allowed.add(arr[i]);
            }
        }
        itemsToBeRemoved+= removeNotAllowed(allowed,maxAllowed);
        return itemsToBeRemoved;
    }

    private static int removeNotAllowed(LinkedList<Integer> allowed,int max){
        int itemsToBeRemoved=0;
        while (allowed.size()>0){
            int no = allowed.peek();
            if(no>max){
                allowed.poll();
                itemsToBeRemoved++;
            }
        }
        return itemsToBeRemoved;
    }

//running
   /* static int minArray(int[] arr) {
        if(arr==null || arr.length==0) {
            return 0;
        }
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        int higjlength=min*2;
        int itemsToBeRemoved = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>higjlength){
                itemsToBeRemoved++;
            }
        }
        return itemsToBeRemoved;
    }*/

}
