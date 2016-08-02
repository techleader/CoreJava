package com.learn.core.java.tree;

import java.lang.*;

/**
 * Created by Meetansh on 18-07-2016.
 */
public class IdenticalSubTree {


    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    static Node findTreeWithLeftAndRightSubtreesEqual(Node root){
        if (root == null){
            return null;
        }
        if(isBothSame(root.left,root.right)){
            return root;
        }
        Node tree = findTreeWithLeftAndRightSubtreesEqual(root.left);
        if(tree == null) {
            tree = findTreeWithLeftAndRightSubtreesEqual(root.right);
        }
        return tree;
    }

    static boolean isBothSame(Node tree1,Node tree2){
        boolean same = false;
        if(tree1!=null && tree2!=null){
            if(tree1.data==tree2.data){
                same = true;
                same = same & isBothSame(tree1.left,tree2.left);
                same = same & isBothSame(tree1.right,tree2.right);
            }
        }
        return same;
    }


    public static void main(java.lang.String[] args){
        Node root = new Node(50);
        root.left = new Node(10);
        root.left.left = new Node(5);
        root.left.right = new Node(10);
        root.right = new Node(60);
        root.right.left = new Node(70);
        root.right.right = new Node(70);
        root.right.left.left = new Node(65);
        root.right.left.right = new Node(80);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        System.out.println(findTreeWithLeftAndRightSubtreesEqual(root));

    }

}
