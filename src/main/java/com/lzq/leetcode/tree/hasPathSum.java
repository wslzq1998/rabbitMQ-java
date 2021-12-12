package com.lzq.leetcode.tree;

public class hasPathSum {
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return travel(root,targetSum,0);
    }
    public boolean travel(TreeNode root, int targetSum,int sum){
        if(root==null) return false;
        if(root.left==null&&root.right==null) return targetSum==sum+root.val;
        if(root.left==null) return travel(root.right,targetSum,sum + root.val);
        if(root.right==null) return travel(root.left,targetSum,sum + root.val);
        return travel(root.left,targetSum,sum+root.val)||travel(root.right,targetSum,sum+root.val);
    }
}
