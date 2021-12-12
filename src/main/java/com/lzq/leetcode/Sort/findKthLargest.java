package com.lzq.leetcode.Sort;

public class findKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
    public static void quickSort(int[] nums,int left,int right){
        if(left>=right) return;
        int i = left,j = right;
        int key = nums[i];
        while(i<j){
            while(i<j&&nums[j]>=key) j--;
            nums[i] = nums[j];
            while(i<j&&nums[i]<=key) i++;
            nums[j] = nums[i];
        }
        nums[i] = key;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }
    public static void swap(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
