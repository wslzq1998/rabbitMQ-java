package com.lzq.leetcode.DP;

/*
* 7 1 5 3 6 4
* 0 0 4 0 3 0
* */
public class maxProfit2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{2,1,2,0,1}));
    }
    public static int maxProfit(int[] prices) {
        int sum = 0;
        int len = prices.length;
        int[] dp = new int[len];
        int cmt = prices[0],minn,cz = Integer.MIN_VALUE;
        dp[0] = 0;
        for(int i=1;i<len;i++){
            if(prices[i]<cmt){
                cmt = prices[i]; dp[i] = 0; cz = Integer.MIN_VALUE;
            }else{
                int cz2 = prices[i] - cmt;
                if(cz2>cz){
                    dp[i] = cz2;dp[i-1] = 0;cz = cz2;
                }else{
                    dp[i] = 0;cmt = prices[i];cz = Integer.MIN_VALUE;
                }
            }
        }
        /*for(int i=0;i<len;i++){
            System.out.print(prices[i]+" ");
        }
        System.out.println();
        for(int i=0;i<len;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();*/
        for(int i=0;i<len;i++){
            sum = sum + dp[i];
        }
        return sum;
    }
}
