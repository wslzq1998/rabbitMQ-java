package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class generateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(n,n,"",list);
        return list;
    }
    public static void dfs(int m,int n,String str,List<String> list){
        if(m==0&&n==0){
            list.add(str);
            return;
        }
        if(m==0)
            dfs(0, n - 1, new String(str + ')'), list);
        else {
            dfs(m - 1, n, new String(str + '('), list);
            if(m<n)
                dfs(m, n - 1, new String(str + ')'), list);
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for(String str:list)
            System.out.println(str);
    }
}
