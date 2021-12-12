package com.lzq.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class preorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
         }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        travelsal(root,list);
        return list;
    }
    public void travelsal(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        travelsal(root.left,list);
        travelsal(root.right,list);
    }
    public void travelsal2(TreeNode root,List<Integer> list){
        if(root==null) return;
        travelsal(root.left,list);
        travelsal(root.right,list);
        list.add(root.val);
    }
}
