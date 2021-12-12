package com.lzq.leetcode.DP;

/*
一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
示例 1：
输入： [1,2,3,1]
输出： 4
解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
示例 2：
输入： [2,7,9,3,1]
输出： 12
解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
示例 3：
输入： [2,1,4,5,3,1,1,3]
       2 1 6 7 9 9 10 12
输出： 12
解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
* */
public class massage {
    public static void main(String[] args) {
        int nums[] = {2,1,4,5,3,1,1,3};
        System.out.println(massage(nums));
    }
    public static int massage(int[] nums) {
        if(nums.length==0) return 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int maxx = dp[0];
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(maxx+nums[i],dp[i-1]);
            maxx = Math.max(maxx,dp[i-1]);
        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);
    }
}
