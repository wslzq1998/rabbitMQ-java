package com.lzq.leetcode.Number;

import java.util.ArrayDeque;
import java.util.Queue;

public class minSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int sum = Integer.MAX_VALUE,cur = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            cur = cur + nums[i];
            queue.add(nums[i]);
            while(cur>=target){
                sum = Math.min(sum,queue.size());
                int poll = queue.poll();
                cur = cur - poll;
            }
        }
        return sum==Integer.MAX_VALUE?0:sum;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}
