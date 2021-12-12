package com.lzq.leetcode.Number;

public class findNthDigit {
    public static int findNthDigit(int n) {
        if(n<=9) return n;
        long m = n-9,num = 2;
        while(true){
            long from = (int)Math.pow(10,num-1);
            if(9*from*num>=m){
                long curr = (int)Math.pow(10,num-1) + m / num - (m % num > 0 ? 0 : 1);
                m = num - (m % num == 0 ? num : m % num);
                long i = curr,count = 0;
                for(i = curr;i!=0&&count<m;i=i/10,count++);
                return (int)i%10;
            }else{
                m = m - 9 * from * num;
                num = num + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
}
