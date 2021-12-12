package com.lzq.leetcode.Map;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.*;

public class isIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> mapp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }else{
                if(mapp.containsKey(t.charAt(i))){
                    if(mapp.get(t.charAt(i))!=s.charAt(i))
                        return false;
                }else{
                    map.put(s.charAt(i),t.charAt(i));
                    mapp.put(t.charAt(i),s.charAt(i));
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
        * "egcd"
          "adfd"
        * */
        System.out.println(isIsomorphic("egcd","adfd"));
    }
}
