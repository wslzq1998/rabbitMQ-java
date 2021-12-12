package com.lzq.leetcode.tree;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
        0
    -10   5
        -3   9
解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
输入：nums = [1,3]
输出：[3,1]
解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
1 2 3 5 6 -8- 9 10 11 12 15
            8
       3         11
   1     5     9   12
     2     6    10   15

链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
* */
public class sortedArrayToBST {
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
    public static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        TreeNode root = new TreeNode(nums[len/2]);
        fz(root,nums,0,len/2-1);
        fz(root,nums,len/2+1,len-1);
        return root;
    }
    public static void fz(TreeNode root,int[] nums,int left,int right){
        if(left>right) return;
        TreeNode yz = new TreeNode();
        int mid = (left+right)/2;
        yz.val = nums[mid];
        if(root.val>yz.val) root.left = yz;
        else root.right = yz;
        fz(yz,nums,left,mid-1);
        fz(yz,nums,mid+1,right);
    }
    public static List<Integer> queueTree(TreeNode root){
        Queue<TreeNode> queue = new ConcurrentLinkedQueue<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        queue.add(root);
        list.add(root==null?null: root.val);
        while(queue.size()!=0){
            TreeNode yz = queue.poll();
            if(yz.left==null&&yz.right==null) break;
            if(yz.left==null){
                list.add(null);
            }else{
                list.add(yz.left.val);
                queue.add(yz.left);
            }
            if(yz.right==null){
                list.add(null);
            }else{
                list.add(yz.right.val);
                queue.add(yz.right);
            }
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(queueTree(root));
    }
}
