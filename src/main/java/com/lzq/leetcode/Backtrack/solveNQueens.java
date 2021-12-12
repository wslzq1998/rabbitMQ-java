package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class solveNQueens {
    public static List<List<String>> list = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        dfs(n,0,new ArrayList<>());
        return list;
    }
    public static void dfs(int n,int cur,List<String> ls){
        if(cur==n) {
            list.add(ls);
            return;
        }
        for(int i=0;i<n;i++){
            int k1 = 0;
            String s = "";
            while(k1<i){ s = s + '.'; k1++;}
            s = s + 'Q'; k1++;
            while(k1<n){ s = s + '.'; k1++;}
            int flag = 1;
            for(int j=0;j<ls.size();j++){
                int x = j, y = ls.get(j).indexOf("Q");
                int xx = ls.size(), yy = i;
                if(y==yy||x==xx||(yy-y)==(xx-x)||(yy-y)==(x-xx)){
                    flag = 0; break;
                }
            }
            if(flag==1) {
                List<String> newLs = new ArrayList<>(ls);
                newLs.add(s);
                dfs(n, cur + 1, newLs);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> list = solveNQueens(4);
        for(List<String> ls:list){
            for(String str:ls){
                System.out.println(str);
            }
            System.out.println("============");
        }
    }
}
