package com.learn.core.java.dynamic;

public class HouseRobbery {
    public static void main(String[] args) {
        int[] houses = {5,2,3,10,1,15};
        System.out.println("Max amount can be robbed : "+ maxAmountCanBeRobbed(houses,5) );

    }

    private static int maxAmountCanBeRobbed(int[] housesWithAmount, int rob){
        if(rob<0) { return 0; }
        if(housesWithAmount.length>= rob+1 && (rob ==0 || rob ==1 )) {
            return housesWithAmount[rob];
        }
        int a = maxAmountCanBeRobbed(housesWithAmount, rob-2) + housesWithAmount[rob];
        int b = maxAmountCanBeRobbed(housesWithAmount, rob-1);
        return (a>b)?a:b;
    }
}
