package com.learn.core.java.codelity;

public class VelocityCalculator2 {

    //    private int solutionRecursive(int[] array) {
//        return noOfMeasuresCanBeTakenForGivenIndex(array, array.length,3);
//    }
//
//
//    private int noOfMeasuresCanBeTakenForGivenIndex(int[] array, int index,int minimunMeasures) {
//        if(index <= 0 || index-(minimunMeasures-1) >= array.length) {
//            return 0; //Measurement cannot be taken
//        }
//        //if velocity is stable for index
//        if(isStable(array[index],array[index-1],array[index-2])){
//            int result =  1 + noOfMeasuresCanBeTakenForGivenIndex(array, index-1,minimunMeasures+1) ;
//           // System.out.println(String.format("%d [%d] is stable with measure => %d",array[index], index, result));
//            return result;
//        } else {
//            return  0 * noOfMeasuresCanBeTakenForGivenIndex(array, index-1,0) ;
//        }
//    }

}
