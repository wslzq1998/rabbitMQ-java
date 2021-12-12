package com.lzq.leetcode.Number;

public class checkPossibility {
    /*
    * 5,8,4,7
    * */
    public boolean checkPossibility(int[] nums) {
        if(nums==null||nums.length<3) return true;
        int sum = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            sum++;
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]<=nums[i+1]) continue;
            sum++;
            if(sum>1) return false;
            if(nums[i+1]>=nums[i-1]) nums[i] = nums[i-1];
            else nums[i+1] = nums[i];
        }
        return true;
    }
}
