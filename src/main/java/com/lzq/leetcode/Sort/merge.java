package com.lzq.leetcode.Sort;
/*
*给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。

* */
public class merge {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{9};
        merge(nums1,0,nums2,1);
        for(int i=0;i<nums1.length;i++){
            System.out.print(nums1[i]+" ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int swp = nums1[0];
        int i=m-1,j=n-1,k=m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        while(i>=0) nums1[k--] = nums1[i--];
        while(j>=0) nums1[k--] = nums2[j--];
    }
}
