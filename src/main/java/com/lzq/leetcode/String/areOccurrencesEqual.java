package com.lzq.leetcode.String;

public class areOccurrencesEqual {
    public boolean areOccurrencesEqual(String s) {
        int[] a = new int[26];
        for(int i=0;i<s.length();i++) a[s.charAt(i)-'a']++;
        int k=0;
        for(int i=0;i<26;i++){
            if(a[i]==0) continue;
            k = a[i];break;
        }
        for(int i=0;i<26;i++){
            if(a[i]==0) continue;
            if(a[i]!=k) return false;
        }
        return true;
    }
}
