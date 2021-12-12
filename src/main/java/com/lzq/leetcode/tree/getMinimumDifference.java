package com.lzq.leetcode.tree;

public class getMinimumDifference {
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
   /*
   * [4,2,6,1,3]
   *        4
   *     2      6
   *   1    3
   * */
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(6);
        TreeNode root4 = new TreeNode(1);
        TreeNode root5 = new TreeNode(3);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        System.out.println(getMinimumDifference(root1));
    }
    public static int getMinimumDifference(TreeNode root) {
        TreeNode left = root.left,right = root.right;
        if(left==null&&right==null) return Integer.MAX_VALUE;
        if(left!=null&&right==null&&left.left==null&&left.right==null){
            return Math.abs(root.val-left.val);
        }
        if(right!=null&&left==null&&right.left==null&&right.right==null){
            return Math.abs(root.val-right.val);
        }
        if(right!=null&&left!=null&&left.left==null&&left.right==null&&right.left==null&&right.right==null){
            return Math.min(Math.abs(root.val-left.val),Math.abs(root.val-right.val));
        }
        while(left!=null){
            if(left.right==null) break;
            left = left.right;
        }
        while(right!=null){
            if(right.left==null) break;
            right = right.left;
        }
        if(left==null) return Math.min(Math.abs(root.val-right.val),getMinimumDifference(root.right));
        if(right==null) return Math.min(Math.abs(root.val-left.val),getMinimumDifference(root.left));
        int tmp = Math.min(Math.abs(left.val-root.val),Math.abs(root.val-right.val));
        return Math.min(Math.min(getMinimumDifference(root.left),getMinimumDifference(root.right)),tmp);
    }

}
