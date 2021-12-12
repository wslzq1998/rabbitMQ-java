package com.lzq.leetcode.String;

import java.math.BigDecimal;

public class splitString {
    public static void main(String[] args) {
        System.out.println(splitString("50043"));
    }
    public static boolean splitString(String s) {
        if(dfs(s,0,new BigDecimal(0),0)) return true;
        return false;
    }
    public static boolean dfs(String s,int index, BigDecimal pre,int cnt){
        if(index==s.length()) return cnt>1;
        BigDecimal cur = new BigDecimal(0);
        for(int i=index;i<s.length();i++){
            cur = cur.multiply(new BigDecimal(10)).add(new BigDecimal(s.charAt(i)-'0'));
            BigDecimal curr = new BigDecimal(cur+"");
            if(cnt==0||pre.compareTo(cur.add(new BigDecimal(1)))==0){
                if(dfs(s,i+1,curr,cnt+1)) return true;
            }
        }
        return false;
    }
}
