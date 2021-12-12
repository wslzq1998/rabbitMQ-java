package com.lzq.leetcode.Backtrack;

import java.util.ArrayDeque;
import java.util.Queue;

public class nearestExit {
    public static void main(String[] args) {
//        char[][] maze = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        char[][] maze = {{'.','.'}};
        int[] entrance = new int[]{0,1};
        System.out.println(nearestExit(maze,entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int[][] nums = new int[maze.length][maze[0].length];
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                nums[i][j] = 2147483647;
            }
        }
        int x = entrance[0],y = entrance[1];
        dfs(maze,nums,x,y,0);
        int minn = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(x==i&&y==0) continue;
            minn = Math.min(nums[i][0],minn);
            if(x==i&&y==nums[i].length-1) continue;
            minn = Math.min(minn,nums[i][nums[i].length-1]);
        }
        for(int i=0;i<nums[0].length;i++){
            if(x==0&&y==i) continue;
            minn = Math.min(nums[0][i],minn);
            if(x==nums.length-1&&y==i) continue;
            minn = Math.min(minn,nums[nums.length-1][i]);
        }
        if(minn==Integer.MAX_VALUE) return -1;
        else return minn;
    }
    /*
    * dfs遍历路径过多，超时
    * */
    public static void dfs(char[][] maze,int[][] nums,int x,int y,int len){
        if(x<0||x>=maze.length||y<0||y>=maze[0].length||maze[x][y]=='+') return;
        if(nums[x][y]==Integer.MAX_VALUE) nums[x][y] = len;
        else{
            if(nums[x][y]>len)
                nums[x][y] = Math.min(nums[x][y],len);
            else return;
        }
        dfs(maze,nums,x+1,y,len+1);
        dfs(maze,nums,x,y+1,len+1);
        dfs(maze,nums,x-1,y,len+1);
        dfs(maze,nums,x,y-1,len+1);
    }
    /*
     * 找出最短路径选择bfs
     * */
    public static class Point{
        int x;
        int y;
        int step;
        public Point(int x,int y,int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    public static int nearestExit2(char[][] maze, int[] entrance) {
        return bfs(maze,entrance[0],entrance[1],0);
    }
    public static int bfs(char[][] maze,int x,int y,int len){
        Queue<Point> queue = new ArrayDeque<>();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int m = maze.length,n = maze[0].length;
        Point point = new Point(x,y,len);
        queue.add(point);
        while (!queue.isEmpty()){
            Point poll = queue.poll();
            if(!(poll.x==x&&poll.y==y)&&(poll.x==0||poll.x==m-1||poll.y==0||poll.y==n-1))
                return poll.step;
            for(int i=0;i<4;i++){
                int px = poll.x + dx[i];
                int py = poll.y + dy[i];
                if(px>=0&&px<m&&py>=0&&py<n&&maze[px][py]=='.'){
                    queue.add(new Point(px,py,poll.step+1));
                    maze[px][py] = '+';
                }
            }
        }
        return -1;
    }
}
