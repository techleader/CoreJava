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

}
