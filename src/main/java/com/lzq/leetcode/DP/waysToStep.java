package com.lzq.leetcode.DP;

/*
三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
示例1:
 输入：n = 3
 输出：4
 说明: 有四种走法
示例2:
 输入：n = 5
 输出：13
* */
public class waysToStep {
    public static void main(String[] args) {
        System.out.println(waysToStep(61));
    }
    public static int waysToStep(int n) {
        long dp[] = new long[1000001];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i=3;i<dp.length;i++){
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%1000000007;
        }
        for(int i=0;i<100;i++){
            System.out.print(dp[i]+",");
        }
        return (int)dp[n-1]%1000000007;
    }
}
