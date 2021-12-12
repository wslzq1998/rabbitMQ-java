package com.lzq.leetcode.greedy;


/*
* 7
* 0 2
* 0 4
* 4 4
* */
public class leastMinutes {
    public static void main(String[] args) {
        System.out.println(leastMinutes(2));
        System.out.println(leastMinutes(3));
        System.out.println(leastMinutes(4));
        System.out.println(leastMinutes(7));
    }
    public static int leastMinutes(int n) {
        int k = 1;
        int sum = 0;
        while(n>=k*2){
            sum = sum + 1;
            k = k * 2;
        }
        return sum+(n>k?2:1);
    }
}
