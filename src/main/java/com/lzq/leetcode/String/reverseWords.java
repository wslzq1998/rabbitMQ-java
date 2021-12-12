package com.lzq.leetcode.String;

public class reverseWords {
    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        String res = "";
        for(int i=strs.length-1;i>=0;i--){
            if(strs[i].equals("")) continue;
            else res = res + strs[i]+" ";
        }
        return res.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
