package com.lzq.leetcode.Number;

public class nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length];
        int l,r;
        for(int i=0;i<nums.length;i++){
            l = 0;
            r = i + 1;
            while(r<nums.length&&nums[r]<nums[i]) r++;
            if(r==nums.length){
                while(l<i&&nums[l]<nums[i]) l++;
                if(l==i) arr[i] = -1;
                else arr[i] = nums[l];
            }else{
                arr[i] = nums[r];
            }
        }
        return arr;
    }

}
