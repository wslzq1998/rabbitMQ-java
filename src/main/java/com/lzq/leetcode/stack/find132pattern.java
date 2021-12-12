package com.lzq.leetcode.stack;

import java.util.Stack;
import java.util.TreeMap;

public class find132pattern {
    //    public boolean find132pattern(int[] nums) {
//        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
//        int leftMin = nums[0];
//        for(int i=2;i<nums.length;i++){
//            treeMap.put(nums[i],treeMap.getOrDefault(nums[i],0)+1);
//        }
//        for(int i=1;i<nums.length-1;i++){
//            if(nums[i]>leftMin){
//                Integer next = treeMap.ceilingKey(leftMin+1);
//                if(next!=null&&next<nums[i]){
//                    return true;
//                }
//            }
//            leftMin = Math.min(leftMin,nums[i]);
//            treeMap.put(nums[i + 1], treeMap.get(nums[i + 1]) - 1);
//            if (treeMap.get(nums[i + 1]) == 0) {
//                treeMap.remove(nums[i + 1]);
//            }
//        }
//        return false;
//    }
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int last = Integer.MIN_VALUE; // 132中的2
        Stack<Integer> sta = new Stack<>();// 用来存储132中的3
        if(nums.length < 3)
            return false;
        for(int i=n-1; i>=0; i--){

            if(nums[i] < last) // 若出现132中的1则返回正确值
                return true;

            // 若当前值大于或等于2则更新2（2为栈中小于当前值的最大元素）
            while(!sta.isEmpty() && sta.peek() < nums[i]){
                last = sta.pop();
            }

            // 将当前值压入栈中
            sta.push(nums[i]);
        }
        return false;
    }
}
