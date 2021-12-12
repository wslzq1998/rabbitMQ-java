package com.lzq.leetcode.graph;

public class numWays {
    public static int sum = 0;
    public static int numWays(int n, int[][] relation, int k) {
        dfs(n,0,k,0,relation);
        return sum;
    }
    public static void dfs(int n,int cur,int k,int curK,int[][] relation){
        if(curK==k){
            if(cur==n-1) sum++;
            return;
        }
        for(int i=0;i<relation.length;i++){
            if(relation[i][0]==cur) {
                dfs(n, relation[i][1], k, curK + 1, relation);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numWays(3,new int[][]{{0,1},{0,2},{2,1},{1,2},{1,0},{2,0}},5));
    }
}
