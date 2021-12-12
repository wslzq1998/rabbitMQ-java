package com.lzq.leetcode.DP;

import java.util.ArrayList;
import java.util.HashMap;

/*
* 1
* 1
* 2
* 1 1
* 3
* 1 1 1
* 4
* 4
* 5
* 4 1
* 6
* 4 1 1
* 7
* 4 1 1 1
* 8
* 4 4
* 9
* 9
* 10
* 9 1
* 11
* 9 1 1
* 12
* 4 4 4
* 13
* 9 4
* */
public class numSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    public static int numSquares(int n) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<=n;i++){
            map.put(i,i);
            for(int j=1;j*j<=i;j++){
                map.put(i,Math.min(map.get(i-j*j)+1,map.get(i)));
            }
        }
        return map.get(n);
    }
}
