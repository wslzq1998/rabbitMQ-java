package com.lzq.leetcode.Map;

import java.util.HashMap;
import java.util.Map;

public class getHint {
    public static String getHint(String secret, String guess) {
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        int a = 0,b = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)) a++;
            else{
                if(map1.containsKey(secret.charAt(i)))
                    map1.put(secret.charAt(i),map1.get(secret.charAt(i))+1);
                else map1.put(secret.charAt(i),1);
                if(map2.containsKey(guess.charAt(i)))
                    map2.put(guess.charAt(i),map2.get(guess.charAt(i))+1);
                else map2.put(guess.charAt(i),1);
            }
        }
        for(Map.Entry entry:map1.entrySet()){
            if(map2.containsKey(entry.getKey())){
                b = b + Math.min(map1.get(entry.getKey()),map2.get(entry.getKey()));
            }
        }
        return ""+a+"A"+b+"B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807","7810"));
    }
}
