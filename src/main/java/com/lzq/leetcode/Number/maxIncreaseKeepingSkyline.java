package com.lzq.leetcode.Number;

public class maxIncreaseKeepingSkyline {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] num1 = new int[grid.length];
        int[] num2 = new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                num1[i] = Math.max(num1[i],grid[i][j]);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                num2[i] = Math.max(num2[i],grid[j][i]);
            }
        }
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                sum = sum + (Math.min(num1[i],num2[j])- grid[i][j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int sum = maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}});
        System.out.println(sum);
    }
}
