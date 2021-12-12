package com.lzq.leetcode.Number;

public class titleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
    public static int titleToNumber(String columnTitle) {
        int[] nums = new int[26];
        for(int i=1;i<=26;i++) nums[i-1] = i;
        int sum = 0;
        for(int i=0;i<columnTitle.length();i++){
            sum = sum * 26 + nums[columnTitle.charAt(i)-'A'];
        }
        return sum;
    }
}
