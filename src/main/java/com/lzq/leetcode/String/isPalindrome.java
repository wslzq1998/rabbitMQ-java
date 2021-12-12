package com.lzq.leetcode.String;

/*
*   给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
* */
public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(12221));
    }
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        String s = x+"";
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    public static boolean isPalindrome2(int x) {
        if(x<0) return false;
        int cnt = 0,k = x;
        while(k!=0){
            cnt = cnt * 10 + k%10;
            k = k / 10;
        }
        if(cnt==x) return true;
        else return false;
    }
}
