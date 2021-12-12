package com.lzq.leetcode.String;

import java.util.HashMap;
import java.util.Map;

public class numSplits {
    public int numSplits(String s) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        int sum = 0;
        for(int i=0;i<s.length();i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map1.get(s.charAt(i))==1)
                map1.remove(s.charAt(i));
            else
                map1.put(s.charAt(i),map1.get(s.charAt(i))-1);
            map2.put(s.charAt(i),map2.getOrDefault(s.charAt(i),0)+1);
            if(map1.size()==map2.size()) sum++;
        }
        return sum;
    }
}
