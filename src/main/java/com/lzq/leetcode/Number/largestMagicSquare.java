package com.lzq.leetcode.Number;

public class largestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int maxx = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int len = Math.min(grid.length-i,grid[i].length-j);
                for(int k=0;k<len;k++){
                    if(isTrue(grid,i,j,i+k,j+k)){
                        maxx = Math.max(maxx,k);
                    }
                }

            }
        }
        return maxx+1;
    }
    public boolean isTrue(int[][] grid,int x,int y,int xEnd,int yEnd){
        int x1=0,x2=0,x3=0,x4=0;
        int[] a = new int[xEnd-x];
        int[] b = new int[xEnd-x];
        for(int i=x;i<=xEnd;i++){
            for(int j=y;j<=yEnd;j++){
                a[i-x] = a[i-x] + grid[i][j];
            }
        }
        for(int i=y;i<=yEnd;i++){
            for(int j=x;j<=xEnd;j++){
                b[i-y] = b[i-y] + grid[j][i];
            }
        }
        for(int i=x,j=y;i<=xEnd&&j<=yEnd;i++,j++) x3 = x3 + grid[i][j];
        for(int i=x,j=yEnd;i<=xEnd&&j>=y;i++,j--) x4 = x4 + grid[i][j];
        for(int i=1;i<xEnd-x;i++){
            if(a[0]!=a[i]) return false;
            if(b[0]!=b[i]) return false;
        }
        return (a[0]==b[0])&&(b[0]==x3)&&(x3==x4);
    }

}
