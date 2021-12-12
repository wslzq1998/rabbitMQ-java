package com.lzq.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class largestValues {
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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int size;
        int maxx;
        TreeNode poll;
        while(!queue.isEmpty()){
            maxx = Integer.MIN_VALUE;
            size = queue.size();
            while(size-->0){
                poll = queue.poll();
                if(poll.left!=null) queue.add(poll.left);
                if(poll.right!=null) queue.add(poll.right);
                if(poll.val>maxx)
                    maxx = poll.val;
            }
            list.add(maxx);
        }
        return list;
    }
}
