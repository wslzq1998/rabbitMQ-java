package com.lzq.leetcode.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0]>0||nums[nums.length-1]<0) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int l = i+1,r = nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[l]);
                    ls.add(nums[r]);
                    list.add(ls);
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++; r--;
                }else if(nums[i]+nums[l]+nums[r]>0){
                    r--;
                }else l++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = threeSum(new int[]{-1,0,1,2,-1,-4});
        for(List<Integer> ls:list){
            for(Integer integer:ls){
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
