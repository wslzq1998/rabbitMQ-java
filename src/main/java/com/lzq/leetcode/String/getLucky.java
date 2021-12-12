package com.lzq.leetcode.String;

public class getLucky {
    public static void main(String[] args) {
        System.out.println(getLucky("leetcode",2));
    }
    public static int getLucky(String s, int k) {
        int[] a = new int[26];
        for(int i=0;i<26;i++){
            if(i<9) a[i] = i+1;
            else a[i] = ((i+1)/10)+((i+1)%10);
        }
        int sum = 0;
        for(int i=0;i<s.length();i++){
            sum = sum + a[s.charAt(i)-'a'];
        }
        for(int i=0;i<k-1;i++){
            int summ = sum,summm=0;
            while(summ!=0){
                summm = summm + summ%10;
                summ = summ/10;
            }
            sum = summm;
        }
        return sum;
    }
}
