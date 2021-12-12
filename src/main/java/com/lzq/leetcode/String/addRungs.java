package com.lzq.leetcode.String;

public class addRungs {
    public static void main(String[] args) {
        System.out.println(addRungs(new int[]{5},10));
    }
    public static int addRungs(int[] rungs, int dist) {
        int count = (rungs[0]-1)/dist;
        for(int i=1;i<rungs.length;i++){
            count+=(rungs[i]-rungs[i-1]-1)/dist;
        }
        return count;
    }
}
