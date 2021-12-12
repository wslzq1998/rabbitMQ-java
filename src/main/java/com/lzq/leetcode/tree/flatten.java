package com.lzq.leetcode.tree;

/*
* [1,2,null,3,4,5]
*               1
*          2
*      3      4
*         5
* 1 2 3 4 5
* */
public class flatten {
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

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
//        TreeNode root6 = new TreeNode(6);
        root2.left = root1;
        root2.right = root4;
        root4.left = root3;
        flatten(root2);
        while(root2!=null){
            System.out.println(root2.val);
            root2 = root2.right;
        }
    }
    public static void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        root.right = left;
        root.left = null;
        TreeNode cursor = root;
        while(cursor.right!=null) cursor = cursor.right;
        cursor.right = right;

    }


}
