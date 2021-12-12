package com.lzq.leetcode.DP;

/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
示例1：
输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：
输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
    偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：
输入：nums = [0]
输出：0
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
2 1 1 2
2 1 3 4
* */
public class rob2 {
    public static void main(String[] args) {
        System.out.println(rob2(new int[]{2,1,1,5}));
    }
    public static int rob2(int[] nums){
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len == 2) return Math.max(nums[0],nums[1]);
        int dp[] = new int[len];
        int dp2[] = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);
        for(int i=2;i<len-1;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            dp2[i+1] = Math.max(dp2[i-1]+nums[i+1],dp2[i]);
        }
        return Math.max(dp[len-2],dp2[len-1]);
    }
}
