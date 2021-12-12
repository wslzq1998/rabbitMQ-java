package com.lzq.leetcode.tree;

public class mergeTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        TreeNode left = mergeTrees(root1.left,root2.left);
        if(left!=null)
            root1.left = left;
        TreeNode right = mergeTrees(root1.right,root2.right);
        if(right!=null)
            root1.right = right;
        root1.val = root1.val + root2.val;
        return root1;
    }
}
