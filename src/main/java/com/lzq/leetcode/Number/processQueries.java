package com.lzq.leetcode.Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class processQueries {
    public static int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=m;i++) map.put(i,i-1);
        for(int i=0;i<queries.length;i++){
            res[i] = map.get(queries[i]);
            for(Map.Entry entry:map.entrySet()){
                if(Integer.parseInt(entry.getValue().toString())<res[i]){
                    map.put(Integer.parseInt(entry.getKey().toString()),Integer.parseInt(entry.getValue().toString())+1);
                }
            }
            map.put(queries[i],0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = processQueries(new int[]{7,5,5,8,3},8);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
