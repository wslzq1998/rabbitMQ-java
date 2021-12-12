package com.lzq.leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class diffWaysToCompute {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(int l:left){
                    for(int r:right){
                        if(expression.charAt(i)=='+') arr.add(l+r);
                        if(expression.charAt(i)=='-') arr.add(l-r);
                        if(expression.charAt(i)=='*') arr.add(l*r);
                    }
                }
            }
        }
        if(expression.indexOf('+')==-1&&expression.indexOf('-')==-1&&expression.indexOf('*')==-1){
            arr.add(Integer.parseInt(expression));
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("1+1-2"));
    }
}
