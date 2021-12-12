package com.lzq.leetcode.Number;

public class getMinDistance {
    public int getMinDistance(int[] nums, int target, int start) {
        int a=nums.length,b=nums.length;
        for(int i=start;i>=0;i--){
            if(nums[i]==target){
                a = Math.abs(i-start);break;
            }
        }
        for(int i=start;i<nums.length;i++){
            if(nums[i]==target){
                b = Math.abs(i-start);break;
            }
        }
        return Math.min(a,b);
    }
}
