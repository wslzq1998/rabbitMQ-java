package com.lzq.leetcode.tree;

public class invertTree {
    private class TreeNode {
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
    public TreeNode invertTree(TreeNode root) {
        TreeNode cmt = root;
        solution(cmt);
        return cmt;
    }
    public void solution(TreeNode root){
        if(root==null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        solution(root.left);
        solution(root.right);
    }
}
