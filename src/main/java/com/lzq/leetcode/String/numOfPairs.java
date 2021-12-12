package com.lzq.leetcode.String;

public class numOfPairs {
    public int numOfPairs(String[] nums, String target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i].length()+nums[j].length()!=target.length()) continue;
                else{
                    if((nums[i]+nums[j]).equals(target)) sum++;
                    if((nums[j]+nums[i]).equals(target)) sum++;
                }
            }
        }
        return sum;
    }
}
