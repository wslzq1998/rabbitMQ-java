package com.lzq.leetcode.Number;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class interchangeableRectangles {
    public static long interchangeableRectangles(int[][] rectangles) {
        long sum = 0;
        int[] flag = new int[rectangles.length];
        for(int i=0;i<rectangles.length;i++){
            int count = 0;
            if(flag[i]==1) continue;
            for(int j=i+1;j<rectangles.length;j++){
                long l1 = (long) rectangles[i][0] * rectangles[j][1];
                long l2 = (long) rectangles[i][1] * rectangles[j][0];
                if(l1==l2){
                    flag[j] = 1;
                    count++;
                }
            }
            for(int k=1;k<=count;k++) sum+=k;
        }
        return sum;
    }
    public static long interchangeableRectangles2(int[][] rectangles) {
        long sum = 0;
        Map<Double,Integer> map = new HashMap<>();
        for(int i=0;i<rectangles.length;i++){
            if(map.containsKey(rectangles[i][0]*1.0/rectangles[i][1]))
                map.put(rectangles[i][0]*1.0/rectangles[i][1],map.get(rectangles[i][0]*1.0/rectangles[i][1])+1);
            else map.put(rectangles[i][0]*1.0/rectangles[i][1],1);
        }
        for(Map.Entry entry: map.entrySet()){
            for (int i=1;i<Integer.parseInt(entry.getValue().toString());i++){
                sum += i;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(interchangeableRectangles2(new int[][]{{4,8},{3,6},{10,20},{15,30}}));
    }
}
