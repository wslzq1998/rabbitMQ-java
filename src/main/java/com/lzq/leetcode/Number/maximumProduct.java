package com.lzq.leetcode.Number;

import java.util.Arrays;

/*
* 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
*/
public class maximumProduct {
    public static void main(String[] args){
        System.out.println(maximumProduct(new int[]{-4,-3,-1,-3,-5}));
    }
    public static int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[2],Math.max(nums[0]*nums[1]*nums[len-1],nums[len-3]*nums[len-2]*nums[len-1]));
    }
}
