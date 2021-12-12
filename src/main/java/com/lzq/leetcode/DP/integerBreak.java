package com.lzq.leetcode.DP;

public class integerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        /*
        * 令dp[i]表示整数i对应的最大乘积，那么dp[i]的值应是dp[j]*(i-j),j属于[1,i-1]的最大值，
        * 同时注意dp[i]对应的值是经过拆分了的，所以还应判断两个数拆分的情况，即j*(i-j)的值，取最大即可。
        * */
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i] = Math.max(j * dp[i-j],dp[i]);
                dp[i] = Math.max(j*(i-j),dp[i]);
            }
        }
        /*
          1
            1
          2
            1: 1*dp[1],dp[2] = 1
        * 3
        *   1: 1*dp[2],dp[3] = 1
            2: 2*dp[1],dp[3] = 2
          4
            1: 1*dp[3],dp[4] = 2
            2: 2*dp[2],dp[4] = 2
            3: 3*dp[1],dp[4] = 3
        * */
        return dp[n];
    }
}
