package com.learn.core.java.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 06-07-2016.
 */
public class TreeNode<T> {
    private T value;
    private List<TreeNode> childs= new LinkedList<>();

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<TreeNode> getChilds() {
        return childs;
    }

    public void addChild(TreeNode child) {
        childs.add(child);
    }
    public void addAllChildsFromNode(TreeNode child) {
        childs.addAll(child.getChilds());
    }

    public boolean isParent(StringS nodeValue) {
        for(TreeNode node : childs) {
            if(node.getValue().toString().equals(nodeValue)){
                return true;
            }
        }
        return false;
    }
}
