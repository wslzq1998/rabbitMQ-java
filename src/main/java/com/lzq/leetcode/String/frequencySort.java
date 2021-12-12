package com.lzq.leetcode.String;

import java.util.*;

public class frequencySort {
    public static class Node{
        Character c;
        int count;

        Node() {}
        Node(Character c,int count){
            this.c = c;
            this.count = count;
        }
    }
    public static String frequencySort(String s) {
        List<Node> list = new ArrayList<>();
        Map<Character,Node> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i)).count++;
            }else{
                Node node = new Node(s.charAt(i),1);
                map.put(s.charAt(i),node);
                list.add(node);
            }
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.count-o2.count;
            }
        });
        String str = "";
        for(int i=list.size()-1;i>=0;i--){
            for(int j=0;j<list.get(i).count;j++) str = str + list.get(i).c;
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.print(frequencySort("raaeaedere"));
    }
}
