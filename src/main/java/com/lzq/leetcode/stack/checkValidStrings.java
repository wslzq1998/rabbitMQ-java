package com.lzq.leetcode.stack;

import java.util.Stack;

public class checkValidStrings {
    public static boolean checkValidString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack1.add(i);
            else if(s.charAt(i)=='*') stack2.add(i);
            else{
                if(stack1.empty() && stack2.empty()) return false;
                if(!stack1.empty()) stack1.pop();
                else
                    stack2.pop();
            }
        }
        while(!stack1.isEmpty()&&!stack2.isEmpty()){
            if (stack1.pop() > stack2.pop()) {
                return false;
            }
        }
        if(!stack1.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
//        "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}
