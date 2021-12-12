package com.lzq.leetcode.String;

import java.util.*;

public class groupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = cz(strs[i]);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else{
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                map.put(s,ls);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry entry:map.entrySet()){
            list.add((List<String>) entry.getValue());
        }
        return list;
    }
    public static String cz(String str){
        String s = "";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        List<List<String>> list = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for(List<String> ls:list){
            for(String str:ls){
                System.out.print(str+" ");
            }
            System.out.println();
        }
    }
}
