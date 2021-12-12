package com.lzq.leetcode.dictionaryTree;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    public Map<String,Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for(Map.Entry entry:map.entrySet()){
            String str = entry.getKey().toString();
            if(str.length()>=prefix.length()&&prefix.equals(str.substring(0,prefix.length()))){
                sum = sum + Integer.parseInt(entry.getValue().toString());
            }
        }
        return sum;
    }
}
