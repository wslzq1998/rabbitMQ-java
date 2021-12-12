package com.lzq.leetcode.stack;

import java.util.Stack;

public class finalPrices {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<prices.length;i++){
            res[i]=prices[i];
            while(!stack.isEmpty()&&prices[stack.peek()]>=prices[i]){
                res[stack.peek()] = prices[stack.pop()]-prices[i];
            }
            stack.add(i);
        }
        return res;
    }
}
