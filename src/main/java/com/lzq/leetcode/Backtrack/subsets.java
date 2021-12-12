package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        List<List<Integer>> list = subsets(new int[]{1,2,3,4});
        for(List<Integer> ls:list){
            for (Integer inte:ls){
                System.out.print(inte+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> ls = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        list.add(new ArrayList<Integer>());
        dfs(nums,used,ls,list);
        return list;
    }
    public static void dfs(int[] nums,boolean[] used,List<Integer> ls,List<List<Integer>> list){
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            List<Integer> ll = new ArrayList<Integer>(ls);
            ll.add(nums[i]);
            list.add(ll);
            boolean[] newUsed = new boolean[nums.length];
            for(int j=0;j<nums.length;j++){
                newUsed[j]=used[j];
                if(j<=i) newUsed[j] = true;
            }
            dfs(nums,newUsed,ll,list);
        }
    }
}
