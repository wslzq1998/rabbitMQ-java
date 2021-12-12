package com.lzq.leetcode.String;

import java.util.ArrayDeque;
import java.util.Queue;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        int maxx = 0;
        for(int i=0;i<s.length();i++){
            if(!queue.contains(s.charAt(i))) queue.add(s.charAt(i));
            else{
                while(!queue.isEmpty()){
                    if(queue.poll()==s.charAt(i))
                        break;
                }
                queue.add(s.charAt(i));
            }
            maxx = Math.max(maxx,queue.size());
        }
        return maxx;
    }

    public static void main(String[] args) {
        System.out.println((-2147486)/10);
    }
}
