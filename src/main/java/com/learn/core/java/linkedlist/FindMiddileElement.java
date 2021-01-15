package com.learn.core.java.linkedlist;

/**
 * Created by Meetansh on 18-07-2016.
 */
public class FindMiddileElement {
    public static void main(String arg[]){
        int i;
        int p=1,q=1;
        int a[] =new int[8];
        for(i=0;i<a.length;i++){
            if(a.length>=q){
                p++;
                q=q+2;
            }else
                break;
        }
        System.out.println("i="+i);
        System.out.println(p);
    }
}
