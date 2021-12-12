package com.lzq.leetcode.String;

import java.util.*;

public class findLongestWord {
    public static String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                return o2.length()-o1.length();
            }
        });
        for(int i=0;i<dictionary.size();i++){
            String str = dictionary.get(i);
            int k = 0,j = 0;
            while(k<s.length()&&j<str.length()){
                if(s.charAt(k)==str.charAt(j)){
                    k++; j++;
                }else k++;
            }
            if(j==str.length()) return str;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.print(findLongestWord("abpcplea",
                new ArrayList<String>(Arrays.asList(new String[]{"a","b","c","d"}))));
    }
}
