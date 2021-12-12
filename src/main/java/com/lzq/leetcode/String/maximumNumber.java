package com.lzq.leetcode.String;

public class maximumNumber {
    public static void main(String[] args) {
        System.out.println(maximumNumber("021",new int[]{9,4,3,5,7,2,1,9,0,6}));
        System.out.println(maximumNumber("5",new int[]{1,4,7,5,3,2,5,6,9,4}));
        System.out.println(maximumNumber("334111",new int[]{0,9,2,3,3,2,5,5,5,5}));
    }
    public static String maximumNumber(String num, int[] change) {
        String str = "";
        int i=0;
        for(i=0;i<num.length();i++){
            int cur = num.charAt(i)-'0';
            if(change[cur]>cur) break;
        }
        int j = i;
        for(j=i;j<num.length();j++){
            int cur = num.charAt(j)-'0';
            if(change[cur]<cur) break;
            else str = str + change[cur];
        }
        return num.substring(0,i)+str+num.substring(j,num.length());
    }
}
