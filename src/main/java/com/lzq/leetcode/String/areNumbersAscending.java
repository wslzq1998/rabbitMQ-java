package com.lzq.leetcode.String;

public class areNumbersAscending {
    public static boolean areNumbersAscending(String s) {
        int num = 0;
        int cur = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') cur = cur * 10 + (s.charAt(i)-'0');
            else{
                if(cur==0) continue;
                if(cur>num) num = cur;
                else return false;
                cur = 0;
            }
        }
        if(cur!=0&&cur<=num) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }
}
