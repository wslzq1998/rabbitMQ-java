package com.lzq.leetcode.DP;

/*
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-sum-query-immutable
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class NumArray {
    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        //[-2, 0, 3, -5, 2, -1]
        //[0, 2], [2, 5], [0, 5]
        //1, -1, -3
        System.out.println(array.sumRange(0,2));
        System.out.println(array.sumRange(2,5));
        System.out.println(array.sumRange(0,5));
    }
    private int sums[] = new int[100001];
    public NumArray(int[] nums) {
        if(nums.length==0) return;
        sums[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sums[i] = sums[i-1]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left==0) return sums[right];
        return sums[right]-sums[left-1];
    }
}
