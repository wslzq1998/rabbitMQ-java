package com.lzq.leetcode.DP;

public class findMaxForm {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=1;i<=strs.length;i++){
            int num0 = charCount(strs[i-1],'0');
            int num1 = charCount(strs[i-1],'1');
            for(int k1=0;k1<=m;k1++){
                for(int k2=0;k2<=n;k2++){
                    dp[i][k1][k2] = dp[i-1][k1][k2];
                    if(k1>=num0&&k2>=num1)
                        dp[i][k1][k2] = Math.max(dp[i-1][k1][k2],dp[i-1][k1-num0][k2-num1]+1);
                }
            }
        }
        return dp[strs.length][m][n];
    }
    public static int charCount(String s,char c){
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
    }
}
