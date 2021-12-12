package com.lzq.leetcode.Number;

import java.util.Arrays;

public class minimumDifference {
    public static int minimumDifference(int[] nums, int k) {
        if(k==1) return 0;
        Arrays.sort(nums);
        int minn = Integer.MAX_VALUE;
        for(int i=k-1;i<nums.length;i++){
            minn = Math.min(minn,nums[i]-nums[i-k+1]);
        }
        return minn;
    }

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{9,4,1,7},2));
    }
}
