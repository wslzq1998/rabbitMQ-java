package com.lzq.leetcode.String;

public class isPalindrome2 {
    public static boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int i=0,j=s.length()-1;
        while(i<=j){
            while(i<j&&!(str.charAt(i)>='a'&&str.charAt(i)<='z')&&!(str.charAt(i)>='0'&&str.charAt(i)<='9')) i++;
            while(j>i&&!(str.charAt(j)>='a'&&str.charAt(j)<='z')&&!(str.charAt(j)>='0'&&str.charAt(j)<='9')) j--;
            if(str.charAt(i)!=str.charAt(j)) return false;
            else{
                i++;j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ab2a"));
    }
}
