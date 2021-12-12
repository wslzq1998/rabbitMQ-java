package com.lzq.leetcode.Backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class combinationSum3 {
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k,n,1,0,0,new ArrayList<>());
        return list;
    }
    public static void backTrack(int k,int n,int index,int curK,int curSum,List<Integer> ls){
        if(curSum > n) return;
        if(curK == k && curSum == n){
            list.add(ls);return;
        }
        for(int i=index;i<=9;i++){
            List<Integer> newLs = new ArrayList<>(ls);
            newLs.add(i);
            backTrack(k,n,i+1,curK+1,curSum+i,newLs);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum3(3,9);
        for(List<Integer> ls:list){
            for(Integer integer:ls){
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
