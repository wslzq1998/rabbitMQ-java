package com.lzq.leetcode.Number;

public class constructRectangle {
    public static int[] constructRectangle(int area) {
        int l = -1,w = -1;
        for(int i=1;i<=Math.sqrt(area);i++){
            if(area%i==0){
                l = area/i; w = i;
            }
        }
        return new int[]{l,w};
    }

    public static void main(String[] args) {
        int[] res = constructRectangle(122122);
        System.out.println(res[0]+" "+res[1]);
    }
}
