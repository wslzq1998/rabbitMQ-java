package com.lzq.leetcode.Number;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class topKFrequent {
    static class node{
        Integer key;
        Integer value;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Queue<node> queue = new PriorityQueue<>((o1, o2) -> {return o2.value-o1.value;});
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        for (Map.Entry entry:map.entrySet()){
            node node = new node();
            node.key = (Integer) entry.getKey();
            node.value = (Integer) entry.getValue();
            queue.add(node);
        }
        int[] cnt = new int[k];
        for(int i=0;i<k;i++) cnt[i] = queue.poll().key;
        return cnt;
    }

    public static void main(String[] args) {
        int[] cnt = topKFrequent(new int[]{1,1,1,2,2,3},2);
        for(int i=0;i<cnt.length;i++)
            System.out.println(cnt[i]);
    }
}
