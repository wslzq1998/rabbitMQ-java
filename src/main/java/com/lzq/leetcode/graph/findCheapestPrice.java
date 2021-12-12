package com.lzq.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findCheapestPrice {
    public static Map<Integer, List<int[]>> graph = new HashMap<>();
    public static int ans = Integer.MAX_VALUE;
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for(int[] flight:flights){
            graph.putIfAbsent(flight[0],new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        dfs(src,dst,k,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static void dfs(int src,int dst,int k,int dist){
        if(src==dst){
            ans = dist;
            return;
        }
        if(graph.containsKey(src)){
            for(int[] flight:graph.get(src)){
                if(dist+flight[1]>=ans||k==-1) continue;
                dfs(flight[0],dst,k-1,dist+flight[1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice(3,edges,0,2,1));
    }
}
