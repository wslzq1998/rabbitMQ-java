package com.lzq.leetcode.Number;

public class productExceptSelf {
    public static void main(String[] args) {

    }
    public static int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length],b = new int[nums.length];
        int cnt = 1,cnt2 = 1;
        for(int i=0;i<nums.length;i++){
            cnt = cnt * nums[i];
            cnt2 = cnt2 * nums[nums.length-1-i];
            a[i] = cnt;
            b[i] = cnt2;
        }
        int[] ret = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0) ret[i] = b[nums.length-1-i-1];
            else if(i==nums.length-1) ret[i] = a[nums.length-2];
            else ret[i] = a[i-1] * b[nums.length-1-i-1];
        }
        return ret;
    }
}
