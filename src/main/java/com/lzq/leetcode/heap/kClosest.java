package com.lzq.leetcode.heap;

import java.util.*;

public class kClosest {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            map.put(i,points[i][0]*points[i][0]+points[i][1]*points[i][1]);
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.parseInt(map.get(o1).toString())-Integer.parseInt(map.get(o2).toString());
            }
        });
        int[][] res = new int[k][2];
        for(int i=0;i<list.size()&&i<k;i++){
            res[i][0] = points[list.get(i)][0];
            res[i][1] = points[list.get(i)][1];
        }
        return res;
    }
}
