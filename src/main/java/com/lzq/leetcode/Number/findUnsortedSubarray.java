package com.lzq.leetcode.Number;

import java.util.Arrays;

public class findUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] newNums = new int[nums.length];
        System.arraycopy(newNums,0,nums,0,nums.length);
        Arrays.sort(newNums);
        int i = 0,j = nums.length-1;
        for(i=0;i<nums.length;i++){
            if(nums[i]==newNums[i]) continue;
            else break;
        }
        for(j=nums.length-1;j>=0;j--){
            if(nums[j]==newNums[j]) continue;
            else break;
        }
        if(i==nums.length) return 0;
        else return j-i+1;
    }

}
