package com.lzq.leetcode.DP;

public class sumLengths {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]<=0){
                dp[i] = nums[i];
            }else{
                dp[i] = nums[i]+dp[i-1];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
