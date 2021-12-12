package com.lzq.leetcode.Number;

/*
* -1 -2 -3 -4 10
* */
public class minStartValue {
    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-1,-2,-3,-4,10}));
        System.out.println(minStartValue(new int[]{-3,2,-3,4,2}));
        System.out.println(minStartValue(new int[]{1,-2,-3}));

    }
    public static int minStartValue(int[] nums) {
        int cnt = 1;
        for(int i=nums.length-1;i>=0;i--){
            cnt = cnt - nums[i];
            if(cnt<1) cnt = 1;
        }
        return cnt;
    }
}
