package com.lzq.leetcode.DP;

/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
示例 1:

输入: [2,3,-2,4]
输出: 6
解释:子数组 [2,3] 有最大乘积 6。
示例 2:
输入: [-2,0,-1]
输出: 0
解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
示例 3:
输入: [2,3,-2,1,-3,5]
输出: 0
2 6 -2  1 -3
2 3 -6 -6 18
链接：https://leetcode-cn.com/problems/maximum-product-subarray
* */
public class maxProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2,0,-1,-3}));
    }
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        int dpMin[] = new int[len];
        int dpMax[] = new int[len];
        int maxx = nums[0];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        for(int i=1;i<len;i++){
            if(nums[i]<0){
                int tmp = dpMax[i-1];
                dpMax[i-1] = dpMin[i-1];
                dpMin[i-1] = tmp;
            }
            dpMax[i] = Math.max(dpMax[i-1]*nums[i],nums[i]);
            dpMin[i] = Math.min(dpMin[i-1]*nums[i],nums[i]);
            maxx = Math.max(dpMax[i],maxx);
            maxx = Math.max(dpMin[i],maxx);
        }
        return  maxx;
    }

}
