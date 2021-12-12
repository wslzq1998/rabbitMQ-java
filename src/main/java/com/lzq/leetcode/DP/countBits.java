package com.lzq.leetcode.DP;

public class countBits {
    public static void main(String[] args) {
        int[] nums = countBits(5);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public static int[] countBits(int num) {
        int[] nums = new int[num+1];
        for(int i=0;i<=num;i++){
            if(i==0) nums[i] = 0;
            else{
                int k = i,count = 0;
                while(k!=0){
                    count = count + k % 2;
                    k = k / 2;
                }
                nums[i] = count;
            }
        }
        return nums;
    }
}
