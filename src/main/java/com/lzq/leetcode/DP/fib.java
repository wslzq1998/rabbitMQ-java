package com.lzq.leetcode.DP;

/*
* 0 1 1 2 3 5 8 13 21 34 55 89
*/
public class fib {
    public static void main(String[] args) {
        for(int i=0;i<=31;i++)
            System.out.print(fib2(i)+" ");
    }
    public static int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int a = 0,b = 1,sum = 1;
        for(int i=2;i<=n;i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
    public static int fib2(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int a = 0,b = 1,sum = 1;
        for(int i=2;i<=n;i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}
