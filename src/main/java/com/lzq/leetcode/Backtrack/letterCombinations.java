package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    public static List<String> list = new ArrayList<>();
    public static List<String> letterCombinations(String digits) {
        String[] strs = new String[10];
        int k = 2;
        for(int i=0;i<26;){
            if(k==7||k==9) {
                strs[k++] = "" + (char) ('a' + i) + (char) ('a' + (i + 1)) + (char) ('a' + (i + 2)) + (char) ('a' + (i + 3));
                i = i + 4;
            }else{
                strs[k++] = "" + (char) ('a' + i) + (char) ('a' + (i + 1)) + (char) ('a' + (i + 2));
                i = i + 3;
            }
        }
        dfs(digits,strs,"",0);
        for(int i=0;i<list.size();i++) System.out.print(list.get(i)+" ");
        return list;
    }
    public static void dfs(String digits,String[] strs,String s,int index){
        if(s.length()==digits.length()){
            list.add(s); return;
        }
        for(int i=index;i<digits.length();i++){
            int cur = Integer.parseInt(""+digits.charAt(i));
            String str = strs[cur];
            for(int j=0;j<str.length();j++){
                String newS = s + str.charAt(j);
                dfs(digits,strs,newS,i+1);
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
