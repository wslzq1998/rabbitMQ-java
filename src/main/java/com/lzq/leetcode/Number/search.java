package com.lzq.leetcode.Number;

public class search {
    public int search(int[] nums, int target) {
        if(target>=nums[0]){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target) return i;
                if(i+1<nums.length&&nums[i+1]<nums[i]) break;
            }
        }else{
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]==target) return i;
                if(i-1>=0&&nums[i-1]>nums[i]) break;
            }
        }
        return -1;
    }
}
