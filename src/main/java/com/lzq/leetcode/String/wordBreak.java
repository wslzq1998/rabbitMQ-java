package com.lzq.leetcode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Map<String,Boolean> map = new HashMap<>();
        for(String str:wordDict) map.put(str,true);
        return dfs(s,"",0,map);
    }
    public static boolean dfs(String s,String str,int index,Map<String,Boolean> map){
        if(index>=s.length()) return true;
        for(int i=index;i<s.length();i++){
            str = str + s.charAt(i);
            if(map.containsKey(str)){
                return dfs(s,"",i+1,map)||dfs(s,str,i+1,map);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak("applepenapple",wordDict));
    }
}
