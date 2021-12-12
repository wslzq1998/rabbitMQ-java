package com.lzq.leetcode.DP;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class nthUglyNumber {
    public static int nthUglyNumber(int n) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        queue.add(1);
        int poll = 1;
        while(n--!=0){
            poll = queue.poll();
            System.out.println(poll+" ");
            if(!queue.contains(poll*2)&&2147483647/2>=poll)
                queue.add(poll*2);
            if(!queue.contains(poll*3)&&2147483647/3>=poll)
                queue.add(poll*3);
            if(!queue.contains(poll*5)&&2147483647/5>=poll)
                queue.add(poll*5);
        }
        return poll;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1690));
    }
}
