package com.lzq.leetcode.String;

public class canBeTypedWords {
    public static void main(String[] args) {
        System.out.println(canBeTypedWords("leet code","e"));
    }
    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] strs = text.split(" ");
        int count = 0;
        for(int i=0;i < strs.length;i++){
            int flag = 1;
            for(int j=0;j<strs[i].length();j++){
                if(brokenLetters.contains(""+strs[i].charAt(j))){
                    flag = 0; break;
                }
            }
            if(flag==1) count++;
        }
        return count;
    }
}
