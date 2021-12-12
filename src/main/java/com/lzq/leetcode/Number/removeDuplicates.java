package com.lzq.leetcode.Number;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,3,3,4,4,5,6,7};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for(int i=0;i<len;i++){
            System.out.print(nums[i]+" ");
        }
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int count = 1,k = 1,cmt = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=cmt){
                count++;nums[k++] = nums[i];cmt = nums[i];
            }
        }
        return count;
    }
}
