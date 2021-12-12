package com.lzq.leetcode.Number;

public class twoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]>target)
                j--;
            else if(numbers[i]+numbers[j]<target)
                i++;
            else break;
        }
        return new int[]{i+1,j+1};
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{-1,0},-1);
        System.out.println(res[0]+" "+res[1]);
    }
}
