package com.lzq.leetcode.Number;

import java.util.Arrays;

public class triangleNumber {
    public static int triangleNumber(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int cnt = nums[i] + nums[j];
                int k = j+1;
                while(k<nums.length){
                    if(cnt<=nums[k]) break;
                    if(nums[k]-nums[i]>=nums[j]||nums[k]-nums[j]>=nums[i]) break;
                    if(cnt>nums[k]&&nums[k]-nums[j]<nums[i]&&nums[k]-nums[i]<nums[j]) sum++;
                    k++;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{3,4,5,6}));
    }
}
