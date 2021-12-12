package com.lzq.leetcode.DP;

/*
给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
输入：grid =
[
[1,3,1],
[1,5,1],
[4,2,1]
]
1 4 5
2 7 6
6 8 7
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
输入：grid =
[
[1,2,3],
[4,5,6]
]
输出：12
链接：https://leetcode-cn.com/problems/minimum-path-sum
* */
public class minPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,2,3}}));
    }
    public static int minPathSum(int[][] grid) {
        int x = grid[0].length;
        int y = grid.length;
        int dp[][] = new int[y][x];
        dp[0][0] = grid[0][0];
        for(int i=1;i<y;i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for(int i=1;i<x;i++){
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for(int i=1;i<y;i++){
            for (int j=1;j<x;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[y-1][x-1];
    }
}
