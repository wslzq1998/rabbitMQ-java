package com.lzq.leetcode.DP;

import java.util.ArrayList;
import java.util.List;

public class partition {
    public static void main(String[] args) {

    }
    public List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,new ArrayList<>());
        return list;
    }
    public void dfs(String s,List<String> ls){
        if(s.length()==0){ list.add(ls);return; }
        String str = "";
        for(int i=0;i<s.length();i++){
            str = str + s.charAt(i);
            if(isPalindrome(str)) {
                List<String> newLs = new ArrayList<>(ls);
                newLs.add(str);
                dfs(s.substring(i+1,s.length()),newLs);
            }
        }
    }
    public boolean isPalindrome(String s){
        if(s.length()==1) return true;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}
