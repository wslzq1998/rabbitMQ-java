package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
* 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
* */
public class permuteUnique {
    public static void main(String[] args) {
        List<List<Integer>> list = permuteUnique(new int[]{1,1,2});
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> ls = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        HashMap<String,Boolean> map = new HashMap<String, Boolean>();
        dfs(map,nums,nums.length,0,list,ls,used);
        return list;

    }
    public static String listString(List<Integer> ls){
        String str = "";
        for(int i=0;i<ls.size();i++) str = str + ls.get(i);
        return str;
    }
    public static void dfs(HashMap<String,Boolean> map,int[] nums, int len, int depth, List<List<Integer>> list, List<Integer> ls, boolean[] used){
        if(depth==len){
            String str = listString(ls);
            if(map.containsKey(str)) return;
            map.put(str,true);
            list.add(ls);
            return;
        }
        for(int i=0;i<len;i++){
            if(used[i]) continue;

            List<Integer> newLs = new ArrayList<Integer>(ls);
            newLs.add(nums[i]);

            boolean[] newUsed = new boolean[len];
            for(int j=0;j<len;j++) newUsed[j] = used[j];
            newUsed[i] = true;

            dfs(map,nums,len,depth+1,list,newLs,newUsed);

        }
    }
}
