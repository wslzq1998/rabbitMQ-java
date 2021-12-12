package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class permute {
    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[]{1,2,3});
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> ls = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,nums.length,0,list,ls,used);
        return list;
    }
    public static void dfs(int[] nums,int len,int depth,List<List<Integer>> list,List<Integer> ls,boolean[] used){
        if(depth==len){
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
            dfs(nums,len,depth+1,list,newLs,newUsed);
        }
    }
}
