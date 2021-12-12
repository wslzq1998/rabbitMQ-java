package com.lzq.leetcode.DP;

/*
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
[7,1,5,3,6,4]
0,0
* */
public class maxProfit {
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int dp[] = new int[prices.length];
        dp[0] = 0;
        int minn = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minn){
                dp[i] = dp[i-1];
                minn = prices[i];
            }else{
                dp[i] = Math.max(dp[i-1],prices[i]-minn);
            }
        }
        return dp[prices.length-1];
    }
}
