package com.learn.core.java.codelity;

import org.junit.Assert;

public class VelocityCalculator {

    public static void main(String[] args) {
        int a[] = {-1,1,3,3,3,2,3,2,1,0};
        VelocityCalculator vc = new VelocityCalculator();
        int result = vc.solution(a);
        Assert.assertEquals(5,result);
        System.out.println("Result " + result);
        int arr[] = new int[10000];
        for(int i=0;i<arr.length;i++){
            arr[i] = 2;
        }
        result = vc.solution(arr);
        Assert.assertEquals(49985001,result);
        System.out.println("Result " + result);
        result = vc.solution(null);
        Assert.assertEquals(0,result);
        System.out.println("Result " + result);
        result = vc.solution(new int[]{1,2});
        Assert.assertEquals(0,result);
        System.out.println("Result " + result);
    }

    private int solution(int[] array) {
        if(array == null ) return 0;
        return noOfMeasuresCanBeTakenForGivenIndex(array);
    }

    private int noOfMeasuresCanBeTakenForGivenIndex(int[] array) {
        int totalPeriod = 0;
        int multiplier = 1;
        for(int i=0; i < array.length-2;i++) {
                if (isStable(array[i], array[i+1], array[i + 2])) {
                    //System.out.println(String.format("Stable  %d, %d", i,totalPeriod));
                    totalPeriod += 1*multiplier;
                    multiplier=multiplier+1;
                } else {
                    multiplier=1;
                }

        }
        return totalPeriod;
    }

    private boolean isStable(int a, int b, int c) {
        return diff(a, b) == diff(b, c);
    }

    private int diff(int no1, int no2) {
        int change = 0;
        if( (no1>=0 && no2>=0) || (no1<0 && no2<0) ){
            change = no2-no1;
        } else {
            change = Math.abs(no2)+ Math.abs(no1);
        }
        return change;
    }
}
