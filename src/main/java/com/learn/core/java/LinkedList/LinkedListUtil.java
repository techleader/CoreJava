package com.learn.core.java.LinkedList;

/**
 * Created by Admin on 05-08-2016.
 */
public class LinkedListUtil {

    public static Node linkedList(int... no){
        if(no == null || no.length==0) return null;
        Node head = null;
        Node current = null;
        for(int x : no){
            Node n = new Node(x);
            if(head==null) {
                head = n;
                current = n;
            } else{
                current.next=n;
                current = current.next;
            }
        }
        return head;
    }

    public static int size(Node list){
        int size = 0;
        while (list!=null){
            size++;
            list=list.next;
        }
        return size;

    }

    public static void print(Node head){
        print(head,", ");
    }
    public static void print(Node head, String sep){
        System.out.println();
        while (head!=null){
            System.out.print(head.data + sep);
            head = head.next;
        }
    }

}
