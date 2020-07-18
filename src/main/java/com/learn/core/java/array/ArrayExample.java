package com.learn.core.java.array;



public class ArrayExample {

  public static int  findNumber(int n,int a[]){
      int number= -1;
            for(int i=0;i<a.length;i++){
                    if(n==a[i]){
                        number=i;
                        break;
                    }
            }
            return number;
    }

    public static void main(String arg[]) {
        int a1[] = {2, 5, 6, 8, 4, 7};
        int a2[] = {8, 7, 9, 4};
        int a3[] = {9,  4, 7, 6, 2, 5};
        int indexValue;

        indexValue = findNumber(5,a1);
        indexfinder(indexValue);
        indexValue = findNumber(5, a2);
        indexfinder(indexValue);
        indexValue = findNumber(5, a3);
        indexfinder(indexValue);
    }

  public static void indexfinder(int indexValue){

      if(indexValue==-1){
          System.out.println("number not founded");
      }else
          System.out.println("number is founded and the index value of number is "+indexValue);

  }

}
