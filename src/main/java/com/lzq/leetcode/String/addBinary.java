package com.lzq.leetcode.String;

public class addBinary {
    public static String addBinary(String a, String b) {
        int len1 = a.length(),len2 = b.length();
        int i=a.length()-1,j=b.length()-1;
        int y = 0;
        StringBuilder s = new StringBuilder();
        while(i>=0&&j>=0){
            int c1 = a.charAt(i--)-'0';
            int c2 = b.charAt(j--)-'0';
            int c3 = c1 + c2 + y;
            int t = c3 % 2;
            y = c3 / 2;
            s.append(t);
        }
        while(i>=0){
            int c1 = a.charAt(i--)-'0';
            int c3 = c1 + y;
            int t = c3 % 2;
            y = c3 / 2;
            s.append(t);
        }
        while(j>=0){
            int c1 = b.charAt(j--)-'0';
            int c3 = c1 + y;
            int t = c3 % 2;
            y = c3 / 2;
            s.append(t);
        }
        if(y!=0) s.append(y);
        s.reverse();
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("10000","11111"));
    }
}
