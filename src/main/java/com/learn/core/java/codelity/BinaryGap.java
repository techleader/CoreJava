package com.learn.core.java.codelity;

public class BinaryGap {
    public static void main(String[] args) {
        new BinaryGap().solution(1041);
    }

    public int solution(int N) {
        // write your code in Java SE 8
        String b = Integer.toBinaryString(N);
        System.out.println(b);
        int Max = 0;
        int prev = -1;
        int next = -1;

        for(int i=0;i<b.length();i++){
            System.out.println(">> Pre " + prev + ", next >> "+ next);
            if((b.charAt(i)) == '1'){
                if(prev == -1 ) {
                    prev = i;
                    continue;
                } else if(next == -1) {
                    next = i;
                    continue;
                }
                if(next-(prev+1)>Max) {
                    Max = next-(prev+1);
                } else {
                    prev = next;
                    next = i;
                }
            }
            continue;
        }
        System.out.println(Max);
        return Max;

    }


}
