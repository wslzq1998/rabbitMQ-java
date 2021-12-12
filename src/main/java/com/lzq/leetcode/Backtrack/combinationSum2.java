package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 1 2 6 7----->8
*                                              1 1 6 7
*                            [1]                 [1]              [6]           [7]
*                           1 6 7               1 6 7            1 1 7
*                     [1]      [6]   [7]       [6]   [7]          [7]
*                     6 7       7               7
*                     [6]      [7]             [7]
*                      7
*                     [7]
* */
public class combinationSum2 {
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backTrack(candidates,used,0,target,0,new ArrayList<>());
        return list;
    }
    public static void backTrack(int[] candidates,boolean[] used,int index, int target,int cur,List<Integer> ls){
        if(cur > target) return;
        if(cur == target){
            list.add(ls); return;
        }
        for(int i=index;i<candidates.length;i++){
            if(used[i]) continue;
            List<Integer> newLs = new ArrayList<>(ls);
            newLs.add(candidates[i]);
            boolean[] newUsed = new boolean[candidates.length];
            for(int j=0;j<used.length;j++) newUsed[j] = used[j];
            newUsed[i] = true;
            backTrack(candidates,newUsed,i+1,target,cur + candidates[i],newLs);
            for(int j=0;j<used.length;j++) used[j] = candidates[j]==candidates[i];
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum2(new int[]{10,1,2,7,6,1,5},8);
        for(List<Integer> ls:list){
            for(Integer integer:ls){
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
