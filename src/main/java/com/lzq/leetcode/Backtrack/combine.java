package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class combine {
    public static List<List<Integer>> list = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        backTrack(n,k,1,0,new ArrayList<>());
        return list;
    }
    public static void backTrack(int n,int k,int index,int cur,List<Integer> ls){
        if(cur == k){
            list.add(ls);return;
        }
        for(int i=index;i<=n;i++){
            List<Integer> newLs = new ArrayList<>(ls);
            newLs.add(i);
            backTrack(n,k,i+1,cur+1,newLs);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list = combine(1,1);
        for(List<Integer> ls:list){
            for(Integer integer:ls){
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
