package com.lzq.leetcode.Backtrack;

public class subsetXORSum {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{3,4,5,6,7,8}));
    }
    public static int subsetXORSum(int[] nums) {
        backTrack(nums,0,0);
        return sum;
    }
    public static int sum = 0;
    public static void backTrack(int[] nums,int index,int cur){
        if(index>=nums.length) {
            sum = sum + cur;
            return;
        }
        for(int i=index;i<nums.length;i++){
            cur = cur ^ nums[i];
            backTrack(nums,i+1,cur);
            cur = cur ^ nums[i];
            if(i== nums.length-1) sum = sum + cur;
        }
    }
}
