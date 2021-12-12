package com.lzq.leetcode.DP;

public class integerReplacement {
    public static int integerReplacement(int n) {
        if(n==1) return 0;
        else{
            if(n%2==0) return integerReplacement(n/2)+1;
            else{
                if(n==2147483647){
                    return Math.min(integerReplacement(1073741824)+1,integerReplacement(n-1))+1;
                }else{
                    return Math.min(integerReplacement(n+1),integerReplacement(n-1))+1;
                }
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(2147483647+1);
        System.out.println(integerReplacement(2147483647));
    }
}
