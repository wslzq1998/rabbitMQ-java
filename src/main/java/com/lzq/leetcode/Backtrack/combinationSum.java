package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates,0,0,target,new ArrayList<>());
        return list;
    }
    public static void backTrack(int[] candidates,int index,int cur,int target,List<Integer> ls){
        if(cur > target) return;
        if(cur == target){
            list.add(ls); return;
        }
        for(int i=index;i<candidates.length;i++){
           List<Integer> newLs = new ArrayList<>(ls);
           newLs.add(candidates[i]);
           backTrack(candidates,i,cur+candidates[i],target,newLs);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum(new int[]{2},1);
        for(List<Integer> ls:list){
            for(Integer integer:ls){
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
