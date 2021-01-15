package com.learn.core.java.linkedlist;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Meetansh on 15-07-2016.
 */
public class LinkedListTraversal {

        class Node{
            int data;
            Node next;
            Node(int d){
                data=d;
            }
        }
    Node start;
    Node current;
    Node first,second;

    void insertNode(int value) {

        if (start == null) {
            start = new Node(value);
            current = start;
        } else {

            Node node = new Node(value);
            current.next = node;
            current = node;

        }


    }
    public int FindMiddleNode(){
        int middleValue=0;
        first=second=start;

        while(second!=null){
            second=second.next;
            if(second!=null && second.next!=null){
                second=second.next;
                first=first.next;
                middleValue=first.data;
            }
        }
        return middleValue;

    }

    void deleteNode(int val){
        first=second=start;
        while(second!=null){
            if(second.data==val){
                if(first==second){
                    start = start.next;
                    first = second = start;
                }else{
                    if(second.next!=null) {
                        first.next=second.next;
                        second=second.next;
                    }else{
                        second=null;
                        first.next=second;
                    }
                }
            }else{

                    first = second;
                    second = second.next;

            }

        }
        System.out.println("After deletion of "+ val +" then list is below ");

    }
        void printLinkedList(){
            Node current;
            current=start;
           // System.out.println("The All Linked list items");
            while (current!=null) {
                System.out.println(current.data);
                current = current.next;
            }

        }
    void findNode(int val){
        while(start!=null){
            if(start.data==val){
               break;
            }

            start=start.next;
        }
        System.out.println("The founded value: ");
        System.out.println(start.data);

    }
    public static void main(String arg[]){
        LinkedListTraversal linkedListTraversal =new LinkedListTraversal();
        linkedListTraversal.insertNode(1);
        linkedListTraversal.insertNode(2);
        linkedListTraversal.insertNode(3);
        linkedListTraversal.insertNode(4);
        linkedListTraversal.insertNode(5);
        linkedListTraversal.insertNode(6);
        linkedListTraversal.insertNode(7);
        linkedListTraversal.insertNode(8);
        linkedListTraversal.insertNode(9);
        linkedListTraversal.insertNode(10);
        linkedListTraversal.printLinkedList();
        linkedListTraversal.deleteNode(5);
        linkedListTraversal.printLinkedList();
        linkedListTraversal.deleteNode(1);
        linkedListTraversal.printLinkedList();
        linkedListTraversal.deleteNode(8);
        linkedListTraversal.printLinkedList();
        linkedListTraversal.deleteNode(3);
        linkedListTraversal.printLinkedList();
        int value=linkedListTraversal.FindMiddleNode();
        System.out.println("middle Node : "+value);

    }
}
