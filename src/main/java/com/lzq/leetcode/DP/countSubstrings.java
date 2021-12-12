package com.lzq.leetcode.DP;

/*
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
示例 1：
输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：
输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
来源：力扣（LeetCode）
aabascaaa

链接：https://leetcode-cn.com/problems/palindromic-substrings
* */
public class countSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aabascaaa"));
    }
    public static int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        int index = 0;
        while(index<len){
            int left = index,right = index;
            while(left>=0&&right<len&&s.charAt(left)==s.charAt(right)){
                left--;right++;count++;
            }
            int left2 = index,right2 = index+1;
            while(left2>=0&&right2<len&&s.charAt(left2)==s.charAt(right2)){
                left2--;right2++;count++;
            }
            index++;
        }
        return count;
    }
}
