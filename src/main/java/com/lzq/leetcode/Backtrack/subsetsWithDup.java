package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* */
public class subsetsWithDup{
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        list.add(new ArrayList<>());
        boolean[] used = new boolean[nums.length];
        backTrack(nums,used,0,new ArrayList<>());
        return list;
    }
    public static void backTrack(int[] nums,boolean[] used,int index,List<Integer> ls){
        for(int i=index;i<nums.length;i++){
            if(used[i]) continue;
            List<Integer> ls2 = new ArrayList<>(ls);
            ls2.add(nums[i]);
            list.add(ls2);
            List<Integer> newLs = new ArrayList<>(ls2);
            boolean[] newUsed = new boolean[used.length];
            for(int j=0;j<used.length;j++) newUsed[j] = used[j];
            newUsed[i] = true;
            backTrack(nums,newUsed,i+1,newLs);
            for(int j=0;j<used.length;j++) used[j] = nums[j]==nums[i];
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list = subsetsWithDup(new int[]{1,2,2});
        for(List<Integer> ls:list){
            for(Integer integer:ls){
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
