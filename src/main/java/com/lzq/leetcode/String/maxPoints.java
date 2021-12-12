package com.lzq.leetcode.String;
/*
* 0,3,0,4,2
* 7,7,5,8,4
* 12,7,7,13,8
* 14,11,13,13,15
* */
public class maxPoints {
    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{0,3,0,4,2},{5,4,2,4,1},{5,0,0,5,1},{2,0,1,0,3}}));
        System.out.println(maxPoints(new int[][]{{0,3,4,5,6}}));
        System.out.println(maxPoints(new int[][]{{0},{1},{2},{3},{4},{5}}));
    }
    public static long maxPoints(int[][] points) {
        long dp[][] = new long[points.length][points[0].length];
        for(int i=0;i<points[0].length;i++){
            dp[0][i] = points[0][i];
        }
        for(int i=1;i<points.length;i++){
            for(int j=0;j<points[i].length;j++){
                long maxNumber = Long.MIN_VALUE;
                for(int k=0;k<points[i-1].length;k++){
                    maxNumber = Math.max(maxNumber,dp[i-1][k]-(Math.abs(j-k)));
                }
                dp[i][j] = points[i][j] + maxNumber;
            }
        }
        long maxx = 0;
        for(int i=0;i<dp[points.length-1].length;i++){
            maxx = Math.max(maxx,dp[points.length-1][i]);
        }
        return maxx;
    }
}
