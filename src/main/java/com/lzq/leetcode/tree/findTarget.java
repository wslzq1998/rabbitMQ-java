package com.lzq.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class findTarget {
    public static class TreeNode {
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
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        dfs(root,ls);
        int i = 0,j = ls.size()-1;
        while(i<j){
            if(ls.get(i)+ls.get(j)>k) j--;
            else if(ls.get(i)+ls.get(j)<k) i++;
            else return true;
        }
        return false;
    }
    public static void dfs(TreeNode root, List<Integer> ls){
        if(root==null) return;
        dfs(root.left,ls);
        ls.add(root.val);
        dfs(root.right,ls);
    }
}
