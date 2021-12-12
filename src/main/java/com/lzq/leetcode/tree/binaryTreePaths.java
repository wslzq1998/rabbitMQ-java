package com.lzq.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null) return list;
        String path = "";
        dfs(root,path,list);
        return list;
    }
    public void dfs(TreeNode root,String path,List<String> list){
        if(root==null){
            list.add(path);
            return;
        }
        String newPath;
        if(path.equals("")) newPath = root.val + "";
        else newPath = path + "->" + root.val;
        dfs(root.left,newPath,list);
        dfs(root.right,newPath,list);
    }
}
