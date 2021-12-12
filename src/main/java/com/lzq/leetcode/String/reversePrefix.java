package com.lzq.leetcode.String;

public class reversePrefix {
    public String reversePrefix(String word, char ch) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        for(i=0;i<word.length();i++){
            if(word.charAt(i)==ch) break;
            else str.append(word.charAt(i));
        }
        if(i==word.length()) return word;
        else return str.reverse().toString()+word.substring(i,word.length());
    }
}
