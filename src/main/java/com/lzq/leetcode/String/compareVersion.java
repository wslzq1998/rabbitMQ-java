package com.lzq.leetcode.String;

public class compareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i=0;i<Math.min(v1.length,v2.length);i++){
            Integer integer1 = Integer.parseInt(v1[i]);
            Integer integer2 = Integer.parseInt(v2[i]);
            if(integer1>integer2) return 1;
            if(integer1<integer2) return -1;
        }
        for(int i=Math.min(v1.length,v2.length);i<Math.max(v1.length,v2.length);i++){
            if(i>=v1.length){
                Integer integer = Integer.parseInt(v2[i]);
                if(integer>0) return -1;
            }else{
                Integer integer = Integer.parseInt(v1[i]);
                if(integer>0) return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01.2.23","1.001.0002"));
    }
}
