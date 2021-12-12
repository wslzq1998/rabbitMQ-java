package com.lzq.leetcode.Number;
/*
* 给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：

ans[i] == nums[i]
ans[i + n] == nums[i]
具体而言，ans 由两个 nums 数组 串联 形成。
* */
public class getConcatenation {
    public static void main(String[] args) {
        System.out.println(getConcatenation(new int[]{1,2,1}));
    }
    public static int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[len*2];
        for(int i=len;i<len*2;i++){
            newNums[i-len] = nums[i-len];
            newNums[i] = nums[i-len];
        }
        for(int i=0;i<len*2;i++){
            System.out.println(newNums[i]);
        }
        return newNums;
    }
}
