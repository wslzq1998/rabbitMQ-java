package com.lzq.leetcode.stack;

import java.util.Stack;

public class removeKdigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int curK = 0;
        int i;
        for(i=0;i<num.length();i++){
            while(!stack.isEmpty()&&stack.peek()>num.charAt(i)){
                stack.pop();
                curK++;
                if(curK==k) break;
            }
            if(curK==k) break;
            stack.add(num.charAt(i));
        }
        while(curK++<k&&!stack.isEmpty()) stack.pop();
        StringBuilder str = new StringBuilder();
        boolean flag = false;
        while(!stack.isEmpty()){
            str = str.append(stack.pop());
        }
        String s = str.reverse().toString()+num.substring(i,num.length());
        if("".equals(s)) return "0";
        int j;
        for(j=0;j<s.length();j++){
            if(s.charAt(j)!='0') break;
        }
        return j==s.length()?"0":s.substring(j,s.length());
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("112",1));
    }
}
