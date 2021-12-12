package com.lzq.leetcode.tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
输入：root = [1,null,2,3]
输出：[1,3,2]
输入：root = []
输出：[]
输入：root = [1]
输出：[1]
输入：root = [1,2]
输出：[2,1]
输入：root = [1,null,2]
输出：[1,2]
 * */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class inorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        modileTraversal(list,root);
        return list;
    }
    public static void modileTraversal(List<Integer> list,TreeNode root){
        if(root==null) return;
        modileTraversal(list,root.left);
        list.add(root.val);
        modileTraversal(list,root.right);
    }
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<Integer>(Arrays.asList(1,null,2,3));
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }
}

