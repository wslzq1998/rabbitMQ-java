package com.lzq.leetcode.Number;

public class isCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] isUsed = new boolean[51];
        for(int i=0;i<ranges.length;i++){
            for(int j=ranges[i][0];j<=ranges[i][1];j++)
                isUsed[j] = true;
        }
        for(int i=left;i<=right;i++){
            if(isUsed[i]==false) return false;
        }
        return true;
    }
}
