package com.lzq.leetcode.Backtrack;

public class numIslands {
    public int numIslands(char[][] grid) {
        int[][] visit = new int[grid.length][grid[0].length];
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'&&visit[i][j]==0) sum++;
                dfs(grid,visit,i,j);
            }
        }
        return sum;
    }
    public void dfs(char[][] grid,int[][] visit,int x,int y){
        if(x>grid.length||y>grid[0].length||x<0||y<0||grid[x][y]=='0'||visit[x][y]==1) return;
        visit[x][y] = 1;
        dfs(grid,visit,x+1,y);
        dfs(grid,visit,x,y+1);
        dfs(grid,visit,x-1,y);
        dfs(grid,visit,x,y-1);
    }
}
