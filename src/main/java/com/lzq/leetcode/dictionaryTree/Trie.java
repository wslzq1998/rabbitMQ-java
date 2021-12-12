package com.lzq.leetcode.dictionaryTree;

/*
* 字典树
* */
public class Trie {
    public static class Node{
        Node[] children = new Node[26];
        boolean isEnd = false;
    }
    public static Node node;
    /** Initialize your data structure here. */
    public Trie() {
        node = new Node();
    }

    /** Inserts a word into the trie. */
    public static void insert(String word) {
        int len = word.length();
        Node nod = node;
        for(int i=0;i<len;i++){
            int cur = word.charAt(i)-'a';
            if(nod.children[cur]==null){
                nod.children[cur] = new Node();
            }
            nod = nod.children[cur];
        }
        nod.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public static boolean search(String word) {
        Node no = prefixExists(word);
        if(no==null) return false;
        return no.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public static boolean startsWith(String prefix) {
        Node no = prefixExists(prefix);
        if(no==null) return false;
        return true;
    }
    public static Node prefixExists(String prefix){
        Node nod = node;
        for(int i=0;i<prefix.length();i++){
            if(nod.children[prefix.charAt(i)-'a']!=null){
                nod = nod.children[prefix.charAt(i)-'a'];
            }else return null;
        }
        return nod;
    }
    public static void main(String[] args) {
        Trie t = new Trie();
        insert("apple");
        System.out.println(search("apple"));
    }
}

