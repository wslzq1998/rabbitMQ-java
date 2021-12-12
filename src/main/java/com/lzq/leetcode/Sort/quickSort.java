package com.lzq.leetcode.Sort;

public class quickSort {
    public static void quickSort(int[] nums,int left,int right){
        /*
        * 7,12,1,25,2,6,1,8,9,5
        * */
        if(left>=right) return;
        int i = left,j = right;
        int num = nums[right];
        while(i<j){
            while(i<j&&nums[i]<=num)
                i++;
            nums[j] = nums[i];
            while(i<j&&nums[j]>=num)
                j--;
            nums[i] = nums[j];
        }
        nums[j] = num;
        quickSort(nums,left,j-1);
        quickSort(nums,j+1,right);
    }

    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void quickSort2(int[] nums, int l, int r) {
        if(l>=r) return;
        int i = l,j = r,mid = nums[(l+r)>>1],temp;
        while(i<j){
            while(nums[i]<mid) i++;
            while(nums[j]>mid) j--;
            if(i<j){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        quickSort2(nums,l,j);
        quickSort2(nums,j+1,r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,12,1,25,2,6,0,8,9,5};
        quickSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
