package com.learn.core.java.tree;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Meetansh on 26-07-2016.
 */
public class Node1{
    int data;
    Node1 left,right,parent;

    Node1(int d){
        data=d;
    }

    static Node1 findNode(Node1 root,int val) {

        if(root==null){
            return null;
        }else
         {
            if (root.data == val){
                return root;
            } else {
                if(root.data>val)
                   return findNode(root.left, val);
                else
                    return findNode(root.right, val);
            }
        }

    }

    static int getNextHigh(Node1 root,int val){
        int a=root.data;
        if(root==null){
            return 0;
        }
        if(root.right!=null){
            return findMinimum(root.right);
        }else
            return findHighParent(root.parent,val);

    }

    static int findMinimum(Node1 root){
        int val=0;
        if(root.left==null){
            val=root.data;
        }else
            val= findMinimum(root.left);

    return val;
    }
    static int findHighParent(Node1 root, int val){
        int highParent=0;
        if(root.data>val){
            highParent=root.data;
        }else
            highParent= findHighParent(root.parent,val);

        return highParent;
    }


    /*static void insertNode(Node1 root,int val) {
        if (root != null) {
            if (root.data > val) {
                if (root.left != null) {
                    insertNode(root.left, val);

                } else {
                    root.left = new Node1(val);
                }
            } else {

                    if (root.right != null) {
                        insertNode(root.right, val);
                    } else {
                        root.right = new Node1(val);
                    }

                }
            }
        }
*/
    static Node1 insertNode(Node1 root,int val){
        if(root == null) {
            return new Node1(val);
        }
        if(root.data>val) {
            root.left = insertNode(root.left, val);
            root.left.parent=root;
        } else {
            root.right = insertNode(root.right, val);
            root.right.parent=root;
        }
        return root;
    }
    static  void preorder(Node1 root) {
        if (root != null) {
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

    }
    public static void main(String[] args) {
        Node1 n1=new Node1(30);
        insertNode(n1,20);
        insertNode(n1,25);
        insertNode(n1,40);
        insertNode(n1,15);
        insertNode(n1,35);
        insertNode(n1,45);
        insertNode(n1,10);
        insertNode(n1,13);
        insertNode(n1,22);
        insertNode(n1,28);
        insertNode(n1,42);
        //preorder(n1);
       Node1 n=findNode(n1,25);
       System.out.println(n.data);
       System.out.println( getNextHigh(n1,25));
    }
}





