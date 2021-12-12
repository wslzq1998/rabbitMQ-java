package com.lzq.leetcode.tree;

import java.util.*;

public class verticalTraversal {
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
    public static class Address{
         int x;
         int y;
         TreeNode node;
         Address(int x,int y,TreeNode node){
             this.x = x;
             this.y = y;
             this.node = node;
         }
    }
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Address> queue = new ArrayDeque<>();
        //查找对应的list,key = 列,value = 该列表示的list
        Map<Integer,List<Integer>> mapList = new HashMap<>();
        Address address = new Address(0,0,root);
        queue.add(address);
        while(!queue.isEmpty()){
            Address poll = queue.poll();
            List<Integer> ls = new ArrayList<>();
            if(mapList.containsKey(poll.y)){
                ls = mapList.get(poll.y);
                ls.add(poll.node.val);
            }else{
                ls.add(poll.node.val);
                list.add(ls);
                mapList.put(poll.y,ls);
            }
            if(poll.node.left!=null){
                Address left = new Address(poll.x, poll.y-1, poll.node.left);
                queue.add(left);
            }
            if(poll.node.right!=null){
                Address right = new Address(poll.x, poll.y+1, poll.node.right);
                queue.add(right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);
        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;
        List<List<Integer>> list = verticalTraversal(root1);
        for(List<Integer> ls:list){
            for (Integer inte:ls){
                System.out.print(inte+" ");
            }
            System.out.println();
        }
    }
}
