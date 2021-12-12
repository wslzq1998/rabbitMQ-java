package com.lzq.leetcode.Backtrack;

import java.util.HashMap;
import java.util.Map;

public class countMaxOrSubsets {
    public static Map<Integer,Integer> map = new HashMap<>();

    public static int countMaxOrSubsets(int[] nums) {
        dfs(nums,0,0);
        int cur = -1,res = -1;
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
            if(Integer.parseInt(entry.getKey().toString())>cur){
                cur = Integer.parseInt(entry.getKey().toString());
                res = Integer.parseInt(entry.getValue().toString());
            }
        }
        return res;
    }
    public static void dfs(int[] nums,int cur,int index){
        if(index==nums.length) return;
        int new_cur = cur | nums[index];
        if(map.containsKey(new_cur)) map.put(new_cur,map.get(new_cur)+1);
        else map.put(new_cur,1);
        dfs(nums,cur,index+1);
        dfs(nums, new_cur, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[]{59,77,37}));
    }
}
