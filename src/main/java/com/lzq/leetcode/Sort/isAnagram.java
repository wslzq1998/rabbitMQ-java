package com.lzq.leetcode.Sort;

public class isAnagram {
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i=0;i<s.length();i++) a[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++) b[t.charAt(i)-'a']++;
        for(int i=0;i<26;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
    public char findTheDifference(String s, String t) {
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i=0;i<s.length();i++) a[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++) b[t.charAt(i)-'a']++;
        for(int i=0;i<26;i++){
            if(b[i]-a[i]==1) return (char) ('a' + i);
        }
        return 'a';
    }
}
