package com.lzq.leetcode.DP;
/*
* 0,1,1,2,1,3,2,3,1,4,3
*
* */
public class getMaximumGenerated {
    public static void main(String[] args) {
        System.out.println(getMaximumGenerated(9));
    }
    public static int getMaximumGenerated(int n) {
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        int[] nums = new int[n+1];
        nums[0] = 0;nums[1] = 1;nums[2] = 1;
        int maxx = Integer.MIN_VALUE;
        for(int i=3;i<=n;i++){
            if(i%2==0) nums[i] = nums[i/2];
            else nums[i] = nums[i/2] + nums[i/2+1];
            maxx = Math.max(maxx,nums[i]);
        }
        return maxx;
    }
}
