package com.lzq.leetcode.tree;

public class mirrorTree {
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
    public TreeNode mirrorTree(TreeNode root) {
        mirror(root);
        return root;
    }
    public void mirror(TreeNode root){
        if(root==null) return;
        TreeNode tree = root.left;
        root.left = root.right;
        root.right = tree;
        mirror(root.left);
        mirror(root.right);
    }
}
