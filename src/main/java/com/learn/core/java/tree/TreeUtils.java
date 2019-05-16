package com.learn.core.java.tree;

/**
 * Created by Meetansh on 21-07-2016.
 */
public class TreeUtils {

    public static int height(Node node){
        if(node == null){
            return 0;
        }
        int leftHeight = height(node.left) + 1;
        int rightHeight = height(node.right) + 1;
        return (leftHeight>rightHeight) ? leftHeight : rightHeight;
    }


    public static void printTree(Node node) {
        int height = height(node);
        for(int i=1; i<= height ; i++) {
            printTree(node, i, height);
            System.out.println("");
        }
    }

    public static void printTree(Node node,int level, int n) {
        if(node == null || level < 1) return;
        if(level == 1) {
            String space = (n> 0) ? String.format("%0" + n + "d", 0).replace("0", " ") : "";
            System.out.print(space + node.data);
        }
        printTree(node.left,level-1,n-level);
        printTree(node.right,level-1,n+level);
    }

    public static void inOrderTraverse(Node root) {
        if(root == null ) return;
        inOrderTraverse(root.left);
        System.out.print(root.data + " ");
        inOrderTraverse(root.right);
    }
}
