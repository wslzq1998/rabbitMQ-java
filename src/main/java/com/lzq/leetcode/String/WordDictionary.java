package com.lzq.leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
    List<String> list;
    public WordDictionary() {
        list = new ArrayList<>();
    }

    public void addWord(String word) {
        if(list.contains(word)) return;
        else list.add(word);
    }

    public boolean search(String word) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).length()!=word.length()) continue;
            boolean flag = true;
            for(int j=0;j<word.length();j++){
                if(word.charAt(j)=='.'||list.get(i).charAt(j)=='.') continue;
                else if(word.charAt(j)!=list.get(i).charAt(j)){
                    flag=false; break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}
