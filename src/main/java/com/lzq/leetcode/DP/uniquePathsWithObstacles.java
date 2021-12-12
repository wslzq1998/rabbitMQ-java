package com.lzq.leetcode.DP;

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
输入：obstacleGrid =
[
[0,0,0],
[0,1,0],
[0,0,0]
]
1 1 1
1 0 1
1 1 2
输出：2
解释：
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
示例 2：
输入：obstacleGrid =
[
[0,1],
[0,0]
]
输出：1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
* */
public class uniquePathsWithObstacles {
    public static void main(String[] args) {
        int obstacleGrid[][] = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int obstacleGrid2[][] = new int[][]{{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid[0].length;
        int y = obstacleGrid.length;
        int dp[][] = new int[y][x];
        if(obstacleGrid[0][0]==1||obstacleGrid[y-1][x-1]==1) return 0;
        dp[0][0] = 1;
        for(int i=1;i<x;i++){
            if(dp[0][i-1]==0)
                dp[0][i] = 0;
            else
                dp[0][i] = 1;
            if(obstacleGrid[0][i]==1)
                dp[0][i] = 0;
        }
        for(int i=1;i<y;i++){
            if(dp[i-1][0]==0)
                dp[i-1][0] = 0;
            else
                dp[i][0] = 1;
            if(obstacleGrid[i][0]==1)
                dp[i][0] = 0;
        }
        for(int i=1;i<y;i++){
            for(int j=1;j<x;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[y-1][x-1];
    }
}
