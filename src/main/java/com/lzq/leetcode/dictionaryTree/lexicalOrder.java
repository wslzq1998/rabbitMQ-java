package com.lzq.leetcode.dictionaryTree;

import java.util.ArrayList;
import java.util.List;

public class lexicalOrder {
    public static class Node{
        Node[] children = new Node[10];
    }
    public static Node node = new Node();
    public static List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        Trie(n);
        blTrie(node,0);
        return list;
    }
    public void Trie(int n){
        String str;
        for(int i=1;i<=n;i++){
            Node root = node;
            str = String.valueOf(i);
            for(int j=0;j<str.length();j++){
                if(root.children[str.charAt(j)-'0']==null){
                    root.children[str.charAt(j)-'0'] = new Node();
                }
                root = root.children[str.charAt(j)-'0'];
            }
        }
    }
    public static void blTrie(Node root,int sum){
        for(int i=0;i<10;i++){
            if(root.children[i]!=null){
                sum = sum * 10 + i;
                list.add(sum);
                blTrie(root.children[i], sum);
            }
        }
    }
}
