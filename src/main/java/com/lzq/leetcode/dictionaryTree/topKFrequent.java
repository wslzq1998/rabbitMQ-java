package com.lzq.leetcode.dictionaryTree;

import java.util.*;

public class topKFrequent {
    public class Node{
        String str;
        int count;
        Node(){}
        Node(String str,int count){
            this.str = str;
            this.count = count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else{
                map.put(words[i],1);
            }
        }
        for(Map.Entry entry:map.entrySet()){
            list.add(new Node(entry.getKey().toString(),Integer.parseInt(entry.getValue().toString())));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.count!=o2.count?o2.count-o1.count:o1.str.compareTo(o2.str);
            }
        });
        List<String> res = new ArrayList<>();
        for(int i=0;i<list.size()&&i<k;i++){
            res.add(list.get(i).str);
        }
        return res;
    }
}
