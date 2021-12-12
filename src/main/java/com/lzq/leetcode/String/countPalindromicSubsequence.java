package com.lzq.leetcode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class countPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }
    public static int countPalindromicSubsequence(String s) {
        Map<Character,Integer> begin = new HashMap<>();
        Map<Character,Integer> end = new HashMap<>();
        for (Map.Entry m: begin.entrySet()){
            System.out.println(m.getValue());
        }
        for(int i=0;i<s.length();i++){
            if(begin.containsKey(s.charAt(i)))
                end.put(s.charAt(i),i);
            else
                begin.put(s.charAt(i),i);
        }
        Set<String> set = new HashSet<>();
        for(Character i='a';i<'a'+26;i++){
            if(!begin.containsKey(i)) continue;
            if(!end.containsKey(i)) continue;
            int left = begin.get(i),right = end.get(i);
            for(int j=left+1;j<right;j++){
                String str = "" + i + s.charAt(j) + i;
                set.add(str);
            }
        }
        return set.size();
    }
}
