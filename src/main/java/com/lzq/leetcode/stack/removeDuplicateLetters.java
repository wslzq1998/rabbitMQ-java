package com.lzq.leetcode.stack;

import java.util.Stack;

public class removeDuplicateLetters {
    /*
    * s = "bcabc"
    * s = "abc"
    * s = "cbacdcbc"
    * s = "acdb"
    * */
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] num = new int[26];
        stack.add(s.charAt(0));
        for(int i=0;i<s.length();i++) {
            num[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']--;
            if(stack.contains(s.charAt(i)))
                continue;
            while(!stack.isEmpty()&&stack.peek()>s.charAt(i)&&num[stack.peek()-'a']>0){
                stack.pop();
            }
            stack.add(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
