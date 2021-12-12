package com.lzq.leetcode.DP;

/*
*   输入：rating = [2,5,3,4,1]
    输出：3
    解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
* */
public class numTeams {
    public static int numTeams(int[] rating) {
        int res = 0;
        //固定每一个中间值
        for (int i = 1; i < rating.length - 1; i++) {
            int leftmin = 0;
            int leftmax = 0;
            int rightmin = 0;
            int rightmax = 0;
            int midval = rating[i];
            for (int j = 0; j < i; j++) {
                if (rating[j] < midval) {
                    leftmin++;
                } else {
                    leftmax++;
                }
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > midval) {
                    rightmax++;
                } else {
                    rightmin++;
                }
            }
            res += leftmax * rightmin;
            res += leftmin * rightmax;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numTeams(new int[]{1,2,3,4}));
    }
}
