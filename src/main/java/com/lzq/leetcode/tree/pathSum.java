package com.lzq.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class pathSum {
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
    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum,0,new ArrayList<>());
        return list;
    }
    public void dfs(TreeNode root,int targetSum,int sum,List<Integer> ls){
        if(root==null) return;
        ls.add(root.val);
        if(root.left==null&&root.right==null){
            if(targetSum==sum+root.val){
                list.add(ls);
            }
        }
        List<Integer> newLeftLs = new ArrayList<>(ls);
        List<Integer> newRightLs = new ArrayList<>(ls);
        dfs(root.left,targetSum,sum + root.val,newLeftLs);
        dfs(root.right,targetSum,sum + root.val,newRightLs);
    }
}
