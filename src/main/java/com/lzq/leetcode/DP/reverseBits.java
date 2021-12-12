package com.lzq.leetcode.DP;

public class reverseBits {
    public static int reverseBits(int num) {
//        String str = Integer.toBinaryString(num);
//        System.out.println(str+" "+str.length());
//        if(str.length()<32) str = "0"+str;
//        String[] strArr = str.split("0");
//        for(int i=0;i<strArr.length;i++) System.out.println(strArr[i]);
//        int res = strArr.length==0?1:strArr[0].length();
//        for (int i = 1; i < strArr.length; i++) {
//            res = Math.max(res, strArr[i].length() + strArr[i - 1].length() + 1);
//        }
//        return res;
        String str = Integer.toBinaryString(num);
        while(str.length()<32) str = "0"+str;
        int maxx = 0, count1 = 0 ,count2 = 0;
        for(int i=0;i<str.length();i++){
            if (str.charAt(i) != '0') {
                count1++; count2++;
            }else{
                maxx = Math.max(count1,maxx);
                count1 = count2+1;
                count2 = 0;
            }
        }
        return Math.max(count1,maxx);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(-1));
    }
}
