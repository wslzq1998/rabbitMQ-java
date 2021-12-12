package com.lzq.leetcode.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findRelativeRanks {
    public static void main(String[] args) {
        String[] strs = findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        for(int i=0;i< strs.length;i++){
            System.out.print(strs[i]+" ");
        }
        System.out.println();
    }
    public static String[] findRelativeRanks(int[] score) {
        int[] newScore = Arrays.copyOf(score,score.length);
        Arrays.sort(newScore);
        List<Integer> list = new ArrayList<Integer>();
        for(int i=newScore.length-1;i>=0;i--) list.add(newScore[i]);
        String[] strs = new String[score.length];
        for(int i=0;i<score.length;i++){
            if(list.indexOf(score[i])==0) strs[i] = "Gold Medal";
            else if(list.indexOf(score[i])==1) strs[i] = "Silver Medal";
            else if(list.indexOf(score[i])==2) strs[i] = "Bronze Medal";
            else strs[i] = ""+(list.indexOf(score[i])+1);
        }
        return strs;
    }
}
