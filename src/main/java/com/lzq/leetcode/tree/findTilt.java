package com.lzq.leetcode.tree;

public class findTilt {
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
   /*
   * [-8,3,0,-8,null,null,null,null,-1,null,8]
   *                    -8
   *         3                    0
   *     -8      null       null      null
   * null    -1
   *      null  8
   * */
    public int findTilt(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 0;
        if(root.left==null) return findTilt(root.right)+Math.abs(sum(root.right));
        if(root.right==null) return findTilt(root.left)+Math.abs(sum(root.left));
        return findTilt(root.left)+findTilt(root.right)+Math.abs(sum(root.left)-sum(root.right));
    }
    public int sum(TreeNode root){
        if(root==null) return 0;
        return sum(root.left)+sum(root.right)+root.val;
    }
}
