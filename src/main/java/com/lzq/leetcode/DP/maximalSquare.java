package com.lzq.leetcode.DP;

/*
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：4
输入：matrix = [["0","1"],["1","0"]]
输出：1
输入：matrix = [["0"]]
输出：0

1 0 1 1 1 0
0 1 1 1 1 1
0 1 1 1 0 1
1 1 1 1 1 1
1 1 1 1 1 1

1 0 1 1 1 0
0 1 1 2 2 1
0 1 2 2 0 1
1 1 2 3 1 1
1 2 2 3 2 2
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
* */
public class maximalSquare {
    public static void main(String[] args) {
        char matrix[][] = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char matrix2[][] = new char[][]{{'0','1'},{'1','0'}};
        char matrix3[][] = new char[][]{{'0'}};
        System.out.println(maximalSquare(matrix3));
    }
    public static int maximalSquare(char[][] matrix) {
        int maxx = Integer.MIN_VALUE;
        int x = matrix.length;
        int y = matrix[0].length;
        int dp[][] = new int[x][y];
        for(int i = 0;i<x;i++){
            dp[i][0] = matrix[i][0]-'0';
            if(dp[i][0]==1) maxx = 1;
        }
        for(int i=0;i<y;i++){
            dp[0][i] = matrix[0][i]-'0';
            if(dp[0][i]==1) maxx = 1;
        }
        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j] = 0;
                }else{
                    if(dp[i-1][j]==0||dp[i][j-1]==0) dp[i][j] = 1;
                    else{
                        int minn = Math.min(dp[i-1][j],dp[i][j-1]);
                        if(matrix[i-minn][j-minn]=='1'){
                            dp[i][j] = minn+1;
                        }else{
                            dp[i][j] = minn;
                        }
                    }
                }
                maxx = Math.max(maxx,dp[i][j]);
            }
        }
        return maxx*maxx;
    }
}
