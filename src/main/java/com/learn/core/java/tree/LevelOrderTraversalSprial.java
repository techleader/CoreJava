package com.learn.core.java.tree;


import java.lang.*;
import java.lang.String;
import static com.learn.core.java.tree.LevelOrderTraversalSprial.*;

/**
 * Created by Meetansh on 20-07-2016.
 */
public class LevelOrderTraversalSprial {


    private static void levelOrderTraversal(Node root){
        for(int i=1;i<=TreeUtils.height(root);i++)
            printNodeAtGiven(root,i);
    }
    private static void printNodeAtGiven(Node node, int level){
        if(node==null){
            return;
        }
        if(level<=1){
            System.out.print(node.data + " ");
        } else {
            printNodeAtGiven(node.left,level-1);
            printNodeAtGiven(node.right,level-1);
        }
    }

    private static void levelOrderTraversalInSpiralForm(Node root){
        boolean spiral = true;
        for(int i=1;i<=TreeUtils.height(root);i++){
            spiral = !spiral;
            printNodeAtGivenInSprialForm(root,i,spiral);
        }
    }

    private static void printNodeAtGivenInSprialForm(Node node, int level,boolean spiral){
        if(node==null){
            return;
        }
        if(level<=1){
            System.out.print(node.data + " ");
        } else {
            if(spiral){
                printNodeAtGivenInSprialForm(node.right,level-1,spiral);
                printNodeAtGivenInSprialForm(node.left,level-1,spiral);
            } else  {
                printNodeAtGivenInSprialForm(node.left,level-1,spiral);
                printNodeAtGivenInSprialForm(node.right,level-1,spiral);
            }
        }
    }



    public static void main(String... strings){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        levelOrderTraversal(root);
        System.out.println("\nSprial Level Traversal");
        levelOrderTraversalInSpiralForm(root);
    }
}
