package com.lzq.leetcode.DP;

public class minFallingPathSum {
    /*
    * 100,-42,-46,-41
    * 31,97,10,-10
    * -58,-51,82,89
    * 51,81,69,-51
    *   */
    public static int minFallingPathSum(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                int minn = Integer.MAX_VALUE;
                minn = Math.min(minn,matrix[i-1][j]);
                if(j-1>=0) minn = Math.min(minn,matrix[i-1][j-1]);
                if(j+1<matrix[i].length) minn = Math.min(minn,matrix[i-1][j+1]);
                matrix[i][j] = minn+matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            res = Math.min(res,matrix[matrix.length-1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{100,-42,-46,-41},{31,97,10,-10},{-58,-51,82,89},{51,81,69,-51}}));
    }
}
