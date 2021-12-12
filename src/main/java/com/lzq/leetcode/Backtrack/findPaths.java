package com.lzq.leetcode.Backtrack;

public class findPaths {
    public static int[][] bj = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow<0||startRow>=m||startColumn<0||startColumn>=n)
            return 1;
        if(maxMove==0&&startRow>=0&&startRow<m&&startColumn>=0&&startColumn<n)
            return 0;
        int sum = 0;
        for(int i=0;i<4;i++){
            sum = (sum + findPaths(m,n,maxMove-1,startRow+bj[i][0],startColumn+bj[i][1]))%1000000007;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findPaths(1, 3, 3, 0, 1));
    }
}
