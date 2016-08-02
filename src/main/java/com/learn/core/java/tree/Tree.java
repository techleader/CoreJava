package com.learn.core.java.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 06-07-2016.
 * <p>
 * Given input format, The first line has the number of employees of a company Z. The next two lines have employees to perform certain operations on.
 * The first employee of the fourth line can be assumed to be the ceo of the company. Each line from then on has the format Employee X Employee Y where X manages Y.
 * (and hence Y forms the child for X).
 * <p>
 * input:
 * 6
 * Rajesh
 * Ravi
 * //Tree Starts here
 * Ram Raj
 * Ram Goku
 * Raj Rajesh
 * Raj Richa
 * Richa Ravi
 * <p>
 * Its known that each person in the company can directly line manage a maximum of 2 other employees.
 * For the two employees in the first two lines, find the lowest common manager.
 * <p>
 * How to construct this tree in java to eventually do an lca?
 */
public class Tree {

    private TreeNode<StringS> root;
    private List<TreeNode> treeNodes = new LinkedList<>();

    public void addNode(TreeNode<StringS> treeNode) {
        if (root == null) {
            root = treeNode;
            treeNodes.add(treeNode);
            return;
        }
        TreeNode parent = findParent(root, treeNode);
        if(parent!=null){
            parent.addAllChildsFromNode(treeNode);
        }
    }

    public void addEmployee(StringS manager, StringS reportee) {
        TreeNode<StringS> managerNode = new TreeNode();
        managerNode.setValue(manager);
        TreeNode<StringS> reporteeNode = new TreeNode();
        reporteeNode.setValue(reportee);
        managerNode.addChild(reporteeNode);
        addNode(managerNode);
    }

    private TreeNode findParent(TreeNode root, TreeNode treeNode) {
        TreeNode parent = null;
        StringS managerName = (StringS) treeNode.getValue();
        TreeNode currentNode = root;
        StringS name = (StringS) currentNode.getValue();
        if (name.equals(managerName)) {
            parent = currentNode;
        } else {
            parent = findParent(currentNode.getChilds(), treeNode);
        }
        return parent;
    }


    private TreeNode findParent(List<TreeNode> nodesToVisit, TreeNode treeNode) {
       for(TreeNode root : nodesToVisit) {
           TreeNode node =  findParent(root,treeNode);
           if(node!=null) return node;
       }
        return null;
    }

    private StringS findLCA(StringS value1, StringS value2){
        List<StringS> path1 = getPath(root,value1);
        System.out.println("Path1 :"+ path1);
        List<StringS> path2 = getPath(root,value2);
        System.out.println("Path2 :"+ path2);
        return findLCA(path1,path2);
    }

    private StringS findLCA(List<StringS> path1, List<StringS> path2){
        if(path1 == null || path2 == null || path1.size() ==0 || path2.size() ==0){
            return null;
        }
        int maxItemToTraverse = path1.size() < path2.size() ? path1.size() : path2.size();
        StringS lca = null;
        for(int i=0 ; i < maxItemToTraverse ; i++){
            if(path1.get(i).equals(path2.get(i))){
                lca = path1.get(i);
            } else {
                return lca;
            }
        }
        return null;
    }

    private List<StringS> getPath(TreeNode root, StringS nodeValue ) {
        if(root == null ){
            return null;
        }
        List<StringS> path = new ArrayList<>();
        StringS currentNode = (StringS)root.getValue();
        if(currentNode.equals(nodeValue)){
            path.add(currentNode);
            return path;
        }
        if(root.isParent(nodeValue)){
            path.add(currentNode);
            path.add(nodeValue);
            return path;
        }
        List<StringS> childpath = getPath(root.getChilds(),nodeValue);
        if(childpath!=null){
            path.add(currentNode);
            path.addAll(childpath);
        }
        return path;
    }



    private List<StringS> getPath(List<TreeNode> nodesToVisit, StringS nodeValue) {

        for(TreeNode root : nodesToVisit) {
            List<StringS> path =  getPath(root,nodeValue);
            if(path!=null && path.size()>0) return path;
        }
        return null;
    }

   /* public static void main(StringS... s ){
        Tree tree = new Tree();
        tree.addEmployee("Saurabh","LM");
        tree.addEmployee("LM","JL");
        tree.addEmployee("LM","GB");
        tree.addEmployee("GB","TK");
        tree.addEmployee("JL","AP");
        tree.addEmployee("JL","AN");
        System.out.println("LCA :" + tree.findLCA("AP","AN"));
    }
*/

}
