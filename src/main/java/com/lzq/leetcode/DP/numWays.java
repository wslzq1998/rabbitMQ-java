package com.lzq.leetcode.DP;
/*
* 0 1
* 1 1
* 2 2
* 3 3
* 4 5
* 5 8
* 6 13
* */
public class numWays {
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
    public static int numWays(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        int a = 1,b = 1,sum = 1;
        for(int i=2;i<=n;i++){
            sum = (a + b)%1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
