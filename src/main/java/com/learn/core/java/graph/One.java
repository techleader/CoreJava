package com.learn.core.java.graph;

import com.learn.core.java.tree.StringS;

import java.util.LinkedList;

/**
 * Created by Meetansh on 11-07-2016.
 */
public class One {

    public static void main(StringS[] s){
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
}
