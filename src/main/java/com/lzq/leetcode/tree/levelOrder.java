package com.lzq.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
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
    private List<List<Integer>> list = new ArrayList<>();
    private Queue<TreeNode> queue = new ArrayDeque<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        queue.add(root);
        int size = queue.size();
        List<Integer> ls = new ArrayList<>();
        while(queue.size()!=0){
            TreeNode cur = queue.poll();
            ls.add(cur.val);
            if(cur.left!=null) queue.add(cur.left);
            if(cur.right!=null) queue.add(cur.right);
            size--;
            if(size==0){
                size = queue.size();
                list.add(ls);
                ls = new ArrayList<>();
            }
        }
        return list;
    }
}
