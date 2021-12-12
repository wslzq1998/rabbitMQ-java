package com.lzq.leetcode.Number;

import java.util.ArrayDeque;
import java.util.Queue;

public class maximumUniqueSubarray {
    public static int maximumUniqueSubarray(int[] nums) {
        Queue<Integer> queue = new ArrayDeque<>();
        int poll,sum = 0;
        int maxx = 0;
        for(int i=0;i<nums.length;i++){
            if(queue.contains(nums[i])){
                while(!queue.isEmpty()){
                    poll = queue.poll();
                    sum = sum - poll;
                    if(poll==nums[i])
                        break;
                }
            }
            sum = sum + nums[i];
            queue.add(nums[i]);
            maxx = Math.max(maxx,sum);
        }
        return maxx;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}));
    }
}
