package com.learn.core.java.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Meetansh on 11-07-2016.
 */
// Java program to find minimum value node in Binary Search Tree

// A binary tree node


class BinaryTree {

    static Node head;
    static Node root;

   /* Given a binary search tree and a number,
     inserts a new node with the given number in
     the correct place in the tree. Returns the new
     root pointer which the caller should then use
     (the standard trick to avoid using reference
     parameters). */

    public Node insert(int data) {
        return insert(root,data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
                node.left.parent = node;
            } else {
                node.right = insert(node.right, data);
                node.right.parent = node;
            }
            return node;
        }
    }


    public Node inOrderSuccessorV2WithoutParent(Node root,Node n) {
        if(root == null || n == null) {  return null;  }
        Node suc = null;
        if(n.right != null ) {
            return minNode(n.right);
        } else {
            while(root!=null) {
                if(root.data< n.data) {
                    root = root.right;
                } else if(root.data > n.data) {
                    suc = root;
                    root = root.left;
                } else {
                    break;
                }
            }
            return suc;
        }
    }

    public Node maxNode(Node root) {
        if(root == null) return null;
        if(root.right != null ) {
            return maxNode(root.right);
        }
        return root;
    }

    public Node maxParent(Node root,int data) {
        if(root == null) return null;
        if(root.data > data ) {
            return root;
        }else {
            return maxParent(root.parent,data);
        }
    }

    public Node minNode(Node root) {
        if(root == null) return null;
        if(root.left != null ) {
            return minNode(root.left);
        }
        return root;
    }

    Node inOrderSuccessorWithRecursion(Node n) {
        if(n==null){  return null;}
        Node successor = null;
        if(n.right != null ) {
            successor = minNode(n.right);
        } else {
            successor = maxParent(n.parent, n.data);
        }
        return successor;
    }

    Node inOrderSuccessorWithLoop(Node n) {
        // step 1 of the above algorithm
        if(n==null){
            return null;
        }
        if (n.right != null) {
            return minValue(n.right);
        }

        // step 2 of the above algorithm
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    boolean isHeapUtil(Node root)
    {
        //  Base case : single node satisfies property
        if (root.left == null && root.right == null)
            return (true);

        //  node will be in second last level
        if (root.right == null)      {
            //  check heap property at Node
            //  No recursive call , because no need to check last level
            return (root.data >= root.left.data);
        }
        else
        {
            //  Check heap property at Node and
            //  Recursive check heap property at left and right subtree
            if (root.data >= root.left.data &&
                    root.data >= root.right.data)
                return ((isHeapUtil(root.left)) &&
                        (isHeapUtil(root.right)));
            else
                return (false);
        }
    }

    /* Given a non-empty binary search tree, return the minimum data
     value found in that tree. Note that the entire tree does not need
     to be searched. */
    Node minValue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 25);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 36);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left;
        System.out.println("Tree..........");
        TreeUtils.printTree(root);
        System.out.println("..........");
        System.out.println("Inorder Traversal ");
        TreeUtils.inOrderTraverse(root);
        System.out.println("Getting Inorder Sucessor of " + temp);

        printSuccessor(tree.inOrderSuccessorWithLoop(temp),temp.data);
        printSuccessor(tree.inOrderSuccessorWithRecursion(temp),temp.data);
        printSuccessor(tree.inOrderSuccessorV2WithoutParent(root,temp),temp.data);

        System.out.println("Is it a heap tree " + tree.isHeapUtil(root));
    }

    private static void printSuccessor(Node suc, int data){
        if (suc != null) {
            System.out.println("Inorder successor of " + data +
                    " is " + suc.data);
        } else {
            System.out.println("Inorder successor does not exist");
        }
    }
}
