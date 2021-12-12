package com.lzq.leetcode.Number;

public class searchRange {
    public static int[] searchRange(int[] nums, int target) {
        int i = 0 ,j = nums.length-1,mod;
        while(i<=j){
            mod = (i + j) / 2;
            if(nums[mod]>target) j = mod-1;
            else if(nums[mod]<target) i = mod+1;
            else{
                i = mod;
                j = mod;
                while (true){
                    if(i<0) {
                        if(j>=nums.length) break;
                        if(nums[j]!=target) break;
                    }
                    if(j>=nums.length){
                        if(nums[i]!=target) break;
                    }
                    if(i>=0&&j<nums.length&&nums[i]!=target&&nums[j]!=target) break;
                    if(i>=0&&nums[i]==target) i--;
                    if(j<nums.length&&nums[j]==target) j++;
                }
                return new int[]{i+1,j-1};
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] res = searchRange(new int[]{1},1);
        System.out.println(res[0]+" "+res[1]);
    }
}
