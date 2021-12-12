package com.lzq.leetcode.Number;

public class plusOne {
    public int[] plusOne(int[] digits) {
        int temp,cnt = 1;
        for(int i = digits.length-1;i>=0;i--){
            temp = digits[i] + cnt;
            cnt = temp / 10;
            digits[i] = temp % 10;
        }
        if(cnt == 1){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int i=0;i<digits.length;res[i+1]=digits[i],i++);
            return res;
        }
        return digits;
    }
}
