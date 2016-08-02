package com.learn.core.java.LinkedList;

/**
 * Created by Meetansh on 19-07-2016.
 */
public class Node {
    int i;
    Node next;
    Node(int a){
        i=a;
    }

    public static  int findMiddleNode(Node node){
        Node fastPointer,slowPointer;
        int val=0;
        fastPointer=slowPointer=node;
        while(fastPointer!=null){
            fastPointer=fastPointer.next;
            if(fastPointer!=null &&fastPointer.next!=null){
                slowPointer=slowPointer.next;
                val=slowPointer.i;
                fastPointer=fastPointer.next;
            }
        }
        return val;
    }
    public static void main(String arg[]){
        Node start=new Node(0);
        Node current;
        current=start;
        for(int i=0;i<15 ;i++){
            Node node= new Node(i+1);
            current.next=node;
            current=node;
        }
        int middile=findMiddleNode(start);
        System.out.println(" middle = "+middile);
        while(start.next!=null){
           start=start.next;
            System.out.println(start.i);
        }



    }
}
