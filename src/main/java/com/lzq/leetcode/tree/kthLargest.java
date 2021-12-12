package com.lzq.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class kthLargest {
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
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        travel(root,list);
        return list.get(k);
    }
    public void travel(TreeNode root,List<Integer> list){
        if(root==null) return;
        travel(root.right,list);
        list.add(root.val);
        travel(root.left,list);
    }
}
