package com.lzq.leetcode.tree;


import sun.reflect.generics.tree.Tree;

public class sortedArrayToBST2 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = solution(nums,0,nums.length-1);
        return root;
    }
    public TreeNode solution(int[] nums,int left,int right) {
        if(left>right) return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = solution(nums,left,mid-1);
        root.right = solution(nums,mid+1,right);
        return root;
    }
}
