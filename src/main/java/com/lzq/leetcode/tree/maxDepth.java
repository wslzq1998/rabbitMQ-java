package com.lzq.leetcode.tree;

import org.omg.CORBA.MARSHAL;

/*
*给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明:叶子节点是指没有子节点的节点。
示例：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度3 。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
* */
public class maxDepth {
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
    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(maxDepth(root));
    }
}
