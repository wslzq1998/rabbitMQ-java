package com.lzq.leetcode.graph;

import java.util.*;

public class allPathsSourceTarget {
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<Integer> ls = new ArrayList<>();
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<graph.length;i++){
            if(!map.containsKey(i))
                map.put(i,new ArrayList<>());
            for(int j=0;j<graph[i].length;map.get(i).add(graph[i][j]),j++);
        }
        List<Integer> lss = new ArrayList<>();
        lss.add(0);
        ls.add(0);
        bfs(graph.length,0,map,lss);
        return list;

    }
    public static void bfs(int n,int curInte,Map<Integer,List<Integer>> map,List<Integer> lss){
        if(curInte==n-1){
            list.add(lss);
            return;
        }
        for(int i=0;i<ls.size();i++){
            Integer cur = ls.get(i);
            for(int j=0;j<map.get(cur).size();j++){
                List<Integer> newLs = new ArrayList<>(lss);
                newLs.add(map.get(cur).get(j));
                ls.remove(0);
                ls.add(map.get(cur).get(j));
                bfs(n,map.get(cur).get(j),map,newLs);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}});
        for(List<Integer> ls:list){
            for(Integer inte:ls){
                System.out.print(inte+" ");
            }
            System.out.println();
        }
    }
}
