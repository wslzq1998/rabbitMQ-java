package com.lzq.leetcode.String;

import java.util.*;

public class longestWord {
    public static String longestWord(String[] words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()!=o2.length()?o2.length()-o1.length():o1.compareTo(o2);
            }
        });
        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            boolean flag = true;
            for(int j=str.length();j>0;j--){
                if(!list.contains(str.substring(0,j))){
                    flag = false; break;
                }
            }
            if(flag) return str;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}
