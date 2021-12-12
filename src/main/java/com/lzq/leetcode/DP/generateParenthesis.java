package com.lzq.leetcode.DP;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    private static List<String> list = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        dfs(n,0,0,"");
        return list;
    }
    public static void dfs(int n,int left,int right,String str){
        if(left==n&&right==n){
            list.add(str); return;
        }
        if(left<n)
            dfs(n,left+1,right,new String(str+"("));
        if(left>right)
            dfs(n,left,right+1,new String(str+")"));
    }
}
