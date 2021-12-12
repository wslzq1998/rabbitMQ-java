package com.lzq.leetcode.DP;

import java.util.Arrays;

public class minSideJumps {
    public static int minSideJumps(int[] obstacles) {
        int[][] dp = new int[4][obstacles.length];
        Arrays.fill(dp[1],9);
        Arrays.fill(dp[2],9);
        Arrays.fill(dp[3],9);
        dp[2][0] = 0;
        dp[1][0] = 1;
        dp[3][0] = 1;
        for(int i=1;i<obstacles.length;i++){
            if(obstacles[i]!=1)
                dp[1][i] = dp[1][i-1];
            if(obstacles[i]!=2)
                dp[2][i] = dp[2][i-1];
            if(obstacles[i]!=3)
                dp[3][i] = dp[3][i-1];
            if(obstacles[i]!=1)
                dp[1][i] = Math.min(dp[1][i],Math.min(dp[2][i],dp[3][i])+1);
            if(obstacles[i]!=2)
                dp[2][i] = Math.min(dp[2][i],Math.min(dp[1][i],dp[3][i])+1);
            if(obstacles[i]!=3)
                dp[3][i] = Math.min(dp[3][i],Math.min(dp[2][i],dp[1][i])+1);
        }
        return Math.min(dp[1][obstacles.length-1],Math.min(dp[2][obstacles.length-1],dp[3][obstacles.length-1]));
    }

    public static void main(String[] args) {
        System.out.println(minSideJumps(new int[]{0,1,2,3,0}));
    }
    public static int minSideJumps2(int[] ob) {
        int n = ob.length;
        int[][] dp = new int[n][3];
        for(int i=0;i<n;i++){
            dp[i][0] = 9;
            dp[i][1] = 9;
            dp[i][2] = 9;
        }
        dp[0][1] = 0;
        dp[0][0] = 1;
        dp[0][2] = 1;

        for(int i=1; i<n; ++i)
        {
            if(ob[i] != 1)
                dp[i][0] = dp[i-1][0];
            if(ob[i] != 2)
                dp[i][1] = dp[i-1][1];
            if(ob[i] != 3)
                dp[i][2] = dp[i-1][2];
            if(ob[i] != 1)
                dp[i][0] = Math.min(dp[i][0], Math.min(dp[i][1], dp[i][2]) + 1);
            if(ob[i] != 2)
                dp[i][1] = Math.min(dp[i][1], Math.min(dp[i][0], dp[i][2]) + 1);
            if(ob[i] != 3)
                dp[i][2] = Math.min(dp[i][2], Math.min(dp[i][0], dp[i][1]) + 1);

        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}
