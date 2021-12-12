package com.lzq.leetcode.Backtrack;

public class findTargetSumWays {
    public int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,0,0,target);
        return count;
    }
    public void dfs(int[] nums,int index,int sum,int target){
        if(index==nums.length){
            if(sum==target) count++;
            return;
        }
        int cnt = 0;
        for(int i = index+1;i<nums.length;i++) cnt = cnt + nums[i];
        if(target-sum-nums[index]>cnt||target-sum-nums[index]<-1*cnt) return;
        dfs(nums,index+1,sum+nums[index],target);
        dfs(nums,index+1,sum-nums[index],target);
    }
}
