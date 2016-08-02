package com.learn.core.java.array;

/**
 * Created by Meetansh on 20-07-2016.
 */
public class Node {
    int data;
    Node left;
    Node right;
    Node(int a){
        data=a;
    }
    static void traverse(Node root){
            printLeft(root.left);
            System.out.println(root.data);
            printRight(root.right);


    }
    static void printRight(Node root){
        if(root!=null){
            System.out.println(root.data);
            printRight(root.right);

        }

    }
    static void printLeft(Node root){
        if(root!=null){
            printLeft(root.left);
            System.out.println(root.data);
        }

    }
    static  void preorder(Node root){
        if(root!=null){
            System.out.print(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root=new Node(3);
        Node n1=new Node(5);
        Node n2=new Node(1);
        Node n3=new Node(9);
        Node n4=new Node(2);
        Node n5=new Node(7);
        Node n6=new Node(6);
        Node n7=new Node(4);
        Node n8=new Node(8);
        root.left=n1;
        root.left.left=n2;
        root.left.right=n7;
        root.left.left.right=n3;
        root.right=n4;
        root.right.left=n6;
        root.right.right=n5;
        root.right.right.left=n8;

        // preorder(root);
        traverse(root);




    }

}
