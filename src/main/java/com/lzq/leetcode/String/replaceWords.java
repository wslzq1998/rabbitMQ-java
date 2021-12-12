package com.lzq.leetcode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class replaceWords {
    public static String replaceWords(List<String> dictionary, String sentence) {
        Map<String,Boolean> map = new HashMap<>();
        for(int i=0;i<dictionary.size();i++) map.put(dictionary.get(i),true);
        String[] strs = sentence.split(" ");
        String res = "";
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            int j=0;
            boolean flag=false;
            while(j<str.length()){
                if(map.containsKey(str.substring(0,j))){
                    res+=str.substring(0,j)+" ";
                    flag=true;
                    break;
                }
                else j++;
            }
            if(!flag) res+=str.substring(0,str.length())+" ";
        }
        return res.trim();
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        System.out.println(replaceWords(dictionary,"the cattle was rattled by the battery"));
    }
}
