package com.lzq.leetcode.String;

public class multiply {
    public static String multiply(String num1, String num2) {
        int[] arr = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            Integer integer = Integer.parseInt(""+num1.charAt(i));
            int index = num1.length()-i-1;
            for(int j=num2.length()-1;j>=0;j--){
                Integer curr = Integer.parseInt(""+num2.charAt(j));
                arr[index] = arr[index] + integer * curr;
                index++;
            }
        }
        for(int i=0;i<arr.length-1;i++){
            arr[i+1] = arr[i+1] + arr[i] / 10;
            arr[i] = arr[i] % 10;
        }
        String res = "";
        boolean flag = false;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!=0) flag = true;
            if(flag) res = res + arr[i];
        }
        return res.equals("")?"0":res;
    }

    public static void main(String[] args) {
        //998001
        System.out.println(multiply("15654646","151616416"));
    }
}
