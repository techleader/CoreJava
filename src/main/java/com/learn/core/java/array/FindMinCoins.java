package com.learn.core.java.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Meetansh on 11-07-2016.
 */
public class FindMinCoins {
    public static void main(String...strings){

        int a[]={10,5,20,1};
        int temp,count=0;
        int amount=78;
        int coin=findMimimumConins(a,amount) ;
        System.out.println("Minimum coins for value : "+ coin);
        System.out.println("Total combinations");
        System.out.println(combinations(a,a.length,27));


       // int[] arr = {12,3,5,8,4,9,5,11};

        //System.out.println(findMaxNumberToBeDeleted(arr));
    }

    private static int combinations(int[] coins,int noOfDigits, int amount) {

            // If n is 0 then there is 1 solution (do not include any coin)
            if (amount == 0)
                return 1;

            // If n is less than 0 then no solution exists
            if (amount < 0)
                return 0;

            // If there are no coins and n is greater than 0, then no solution exist
            if (noOfDigits <=0 && amount >= 1)
                return 0;

            // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
            return combinations( coins,  noOfDigits - 1, amount ) + combinations( coins, noOfDigits, amount-coins[noOfDigits-1] );
    }

    private static int findMimimumConins(int[] conis,int amount) {
        if (conis.length == 0 || amount == 0) {
            return 0;
        }
        int noOfCoins = 0;
        while (amount>0){
            int coin = getHighestAvailableCoin(conis,amount);
            System.out.println("Amount : "+ amount + " - coin: " +coin);
            noOfCoins++;
            amount = amount-coin;
        }
        return noOfCoins;
    }

    public static int getHighestAvailableCoin(int []conis,int amount){
         int coin,val,temp;
         coin=0;
        for(int i=0; i<conis.length ; i++) {
            if(conis[i]>coin && amount>=conis[i]){
                coin=conis[i];
            }
        }    return coin;
    }

    private static int  findMaxNumberToBeDeleted(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        List<Integer> allowedNo = new LinkedList<>();
        int min = array[0];
        int max = min * 2;
        int totalNoToBeRemoved = 0;
        for(int i=1; i<array.length ; i++){
            if(array[i]< min){
                min = array[i];
                allowedNo.add(array[i]);
                final int newMax = min * 2;
                max = newMax;
                List<Integer> remove = allowedNo.stream().filter(no -> no>newMax).collect(Collectors.toList());
                totalNoToBeRemoved += remove.size();
                allowedNo.removeAll(remove);
            } else if(array[i]< min){
                allowedNo.add(array[i]);
            } else {
                totalNoToBeRemoved++;
            }
        }
        return totalNoToBeRemoved;
    }
}
