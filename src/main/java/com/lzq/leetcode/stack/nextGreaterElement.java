package com.lzq.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class nextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty()&&stack.peek()<nums2[i]){
                map.put(stack.peek(),nums2[i]);
                stack.pop();
            }
            stack.add(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i]))
                res[i] = map.get(nums1[i]);
            else res[i] = -1;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
