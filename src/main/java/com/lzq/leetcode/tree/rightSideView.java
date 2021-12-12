package com.lzq.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class rightSideView {
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int k = queue.size();
            TreeNode tree = null;
            while(k-->0){
                tree = queue.poll();
                if(tree.left!=null)
                    queue.add(tree.left);
                if(tree.right!=null)
                    queue.add(tree.right);
            }
            if(tree!=null) list.add(tree.val);
        }
        return list;
    }
}
