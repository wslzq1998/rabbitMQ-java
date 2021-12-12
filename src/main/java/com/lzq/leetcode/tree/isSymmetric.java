package com.lzq.leetcode.tree;

import java.util.List;

/*
给定一个二叉树，检查它是否是镜像对称的。
二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    1
   / \
  2   2
   \   \
   3    3
* */
public class isSymmetric {
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
    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        if((root.left==null&&root.right!=null)||(root.left!=null&&root.right==null)) return false;
        return isTrue(root.left,root.right);
    }
    public static boolean isTrue(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null) return true;
        if((root1==null&&root2!=null)||(root1!=null&&root2==null)) return false;
        if(root1.val!= root2.val) return false;
        return isTrue(root1.left,root2.right)&&isTrue(root1.right,root2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }
}
