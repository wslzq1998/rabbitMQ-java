package com.lzq.leetcode.String;

public class isPalindrome3 {
    public static boolean isPalindrome(String s) {
        if(s.equals("")) return true;
        int i=0,j=s.length()-1;
        while(i<j){
            while(i<j&&!isChar(s.charAt(i))) i++;
            while(i<j&&!isChar(s.charAt(j))) j--;
            char c1 = Character.toLowerCase(s.charAt(i));
            char c2 = Character.toLowerCase(s.charAt(j));
            if(c1!=c2) return false;
            i++;j--;
        }
        return true;
    }
    public static boolean isChar(char c){
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("nowcoder Is Best tsebsi: redoc won"));
    }
}
