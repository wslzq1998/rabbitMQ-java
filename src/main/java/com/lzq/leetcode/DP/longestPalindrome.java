package com.lzq.leetcode.DP;

/*
给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：
输入：s = "cbbd"
输出："bb"
示例 3：
输入：s = "a"
输出："a"
示例 4：
输入：s = "ac"
输出："a"
* */
public class longestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len==0) return "";
        if(len==1) return s;
        int maxLeft = 0;
        int maxRight = 0;
        for(int i = 0;i<len;i++){
            int left = i,right = i;
            while(left>=0&&right<len&&s.charAt(left)==s.charAt(right)){
                left--; right++;
            }
            int left2 = i,right2 = i+1;
            while(left2>=0&&right2<len&&s.charAt(left2)==s.charAt(right2)){
                left2--; right2++;
            }
//            System.out.println(left+" "+right+"   "+left2+" "+right2);
            if(right-left>maxRight-maxLeft){
                maxLeft = left;
                maxRight = right;
            }
            if(right2-left2>maxRight-maxLeft){
                maxLeft = left2;
                maxRight = right2;
            }
        }
//        System.out.println(maxLeft+" "+maxRight);
        return s.substring(maxLeft+1,maxRight);
    }
}
