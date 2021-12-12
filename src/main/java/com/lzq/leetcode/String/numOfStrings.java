package com.lzq.leetcode.String;

public class numOfStrings {
    public static int numOfStrings(String[] patterns, String word) {
        int sum = 0;
        for(int i=0;i<patterns.length;i++){
            if(word.contains(patterns[i])){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numOfStrings(new String[]{"a","abc","bc","d"},"abc"));
    }
}
