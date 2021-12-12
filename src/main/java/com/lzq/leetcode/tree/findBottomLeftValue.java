package com.lzq.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class findBottomLeftValue {
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
    public int findBottomLeftValue(TreeNode root) {
        TreeNode res = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cnt = queue.poll();
            if(cnt.right!=null){
                res = cnt.right;
                queue.add(cnt.right);
            }
            if(cnt.left!=null) {
                res = cnt.left;
                queue.add(cnt.left);
            }
        }
        return res.val;
    }
}
