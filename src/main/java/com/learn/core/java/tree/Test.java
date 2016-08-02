package com.learn.core.java.tree;

/**
 * Created by Meetansh on 11-07-2016.
 */
public class Test {
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

    public static void main(StringS[] s){
        int c[] ={1,5,6,9};
        System.out.println(getCount(c,11));
    }
}
