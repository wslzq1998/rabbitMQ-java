package com.lzq.leetcode.Map;

import java.util.HashMap;
import java.util.Map;

public class findLHS {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int res = 0;
        for(Map.Entry entry:map.entrySet()){
            if(map.containsKey(Integer.parseInt(entry.getKey().toString())+1)){
                res = Math.max(res,Integer.parseInt(entry.getValue().toString())+map.get(Integer.parseInt(entry.getKey().toString())+1));
            }
        }
        return res;
    }
}
