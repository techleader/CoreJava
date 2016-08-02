package com.learn.core.java.array;

import java.util.*;


public class TestArray {
    public static void main(String arg[]) {
        int a[] ={};
        int v=0;
       // System.out.println(v++);
        //...............................................
        List<Integer> in= new ArrayList<>(2);
        in.add(1);
        in.add(1,10);
        in.add(2,20);
        in.add(2,20);

        Iterator<Integer> iterator=in.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
           // in.remove(2);
            iterator.remove();
        }
        System.out.println(in);
        in.add(3);

        ArrayList<Integer> num=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(40);



        System.out.println(queue.remove());

    }

}