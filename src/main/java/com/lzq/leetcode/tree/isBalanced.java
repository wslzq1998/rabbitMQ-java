package com.lzq.leetcode.tree;
/*
* 给定一个二叉树，判断它是否是高度平衡的二叉树。
* */
/*
* [1,2,2,3,null,null,3,4,null,null,4]
*                   1
*         2                   2
*    3       null       null       3
* 4   null                    null    4
* */
public class isBalanced {
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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(treeHeight(root.left)-treeHeight(root.right))<=1){
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        else return false;
    }
    public int treeHeight(TreeNode root){
        if(root==null) return 0;
        return Math.max(treeHeight(root.left)+1,treeHeight(root.right)+1);
    }
}
