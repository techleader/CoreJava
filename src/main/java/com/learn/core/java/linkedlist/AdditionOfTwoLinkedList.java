package com.learn.core.java.linkedlist;


/**
 * Created by Admin on 05-08-2016.
 */
public class AdditionOfTwoLinkedList {

    private static Node sumList(Node list1, Node list2) {
        int s1 = LinkedListUtil.size(list1);
        int s2 = LinkedListUtil.size(list2);
        if(s1 > s2){
            list2 = appendZero(list2,s1-s2);
        } else if(s2 > s1){
            list1 = appendZero(list1,s2-s1);
        }
        return sum(list1,list2);
    }

    private static Node appendZero(Node list,int no){
        Node newlist = list;
        for(int i=0;i<no;i++){
            Node zero = new Node(0);
            zero.next = list;
            newlist = zero;
        }
        return newlist;
    }

    private static Node sum(Node list1, Node list2) {
        if (list1 == null || list2 == null)
            return null;
        else if (list1.next == null && list2.next == null) {
            Node newNode = new Node(0);
            return sumNode(list1, list2, newNode);
        } else if (list1.next == null) {
            Node newList = sumList(list1, list2.next);
            return sumNode(newList, list2, new Node(0));
        } else if (list2.next == null) {
            Node newList = sumList(list1.next, list2);
            return sumNode(list1, newList, new Node(0));
        } else {
            Node newList = sumList(list1.next, list2.next);
            return sumNode(list1, list2, newList);
        }
    }

    private static Node sumNode(Node list1, Node list2, Node newNode) {
        if (list1 == null || list2 == null || newNode == null) return null;
        int sum = list1.data + list2.data + newNode.data;
        int carry = 0;
        if (sum >= 10) {
            newNode.data = sum % 10;
            carry = sum / 10;
        } else {
            newNode.data = sum;
        }
        Node carryNode = new Node(carry);
        carryNode.next = newNode;
        newNode = carryNode;
        return newNode;
    }


    public static void main(String[] args) {
        Node list1 = LinkedListUtil.linkedList(6, 5);
        Node list2 = LinkedListUtil.linkedList(5, 4, 8);
        LinkedListUtil.print(list1, "");
        LinkedListUtil.print(list2, "");
        LinkedListUtil.print(sumList(list1, list2), "");


    }
}
