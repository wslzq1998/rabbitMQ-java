package com.lzq.leetcode.DP;

public class countSquares {
    /*
    0,1,1,1
    1,1,1,1
    0,1,1,1

    0 1 1 1
    1 1 2 2
    0 1 2 3
    */
    public static int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int sum = 0;
        for(int i=0;i<matrix.length;i++){
            dp[i][0] = matrix[i][0];
            sum = sum + dp[i][0];
        }
        for(int i=1;i<matrix[0].length;i++){
            dp[0][i] = matrix[0][i];
            sum = sum + dp[0][i];
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    sum = sum + dp[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{{1,0,1},{1,1,0},{1,1,0}}));
    }
}
