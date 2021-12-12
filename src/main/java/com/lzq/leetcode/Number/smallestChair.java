package com.lzq.leetcode.Number;

import java.util.Arrays;
import java.util.Comparator;

public class smallestChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] chairs = new int[times.length];
        int beginTime = times[targetFriend][0];
        Arrays.sort(times, (o1,o2)->{
            return o1[0]-o2[0];
        });
        int index = 0;
        for(int i=0;i<times.length;i++){
            for(int j=0;j<times.length;j++){
                if(chairs[j]<=times[i][0]){
                    chairs[j]=times[i][1];
                    if(times[i][0]==beginTime) index = j;
                    break;
                }
            }
        }
        return index;
    }
}
