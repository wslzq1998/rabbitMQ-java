package com.lzq.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class kthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a,b)->{return a-b;});
        for(int[] cnt:matrix){
            for(Integer inte:cnt){
                queue.add(inte);
            }
        }
        int i = 0;
        int poll = 0;
        while(i<k){
            poll = queue.poll();
            i++;
        }
        return poll;
    }
}
