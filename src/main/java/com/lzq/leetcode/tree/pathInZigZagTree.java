package com.lzq.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pathInZigZagTree {
    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(26));
    }
    public static List<Integer> pathInZigZagTree(int label) {
        int num = 1,cur = 1,curK = 1;
        List<List<Integer>> list = new ArrayList<>();
        while(true){
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<num;i++){
                if(curK%2==1) ls.add(cur);
                else ls.add(cur+(num-i-1)-i);
                cur++;
            }
            curK++;
            num = num * 2;
            list.add(ls);
            if(cur>label) break;
        }
        int index = 0;
        for(index=0;index<list.get(list.size()-1).size()&&list.get(list.size()-1).get(index)!=label;index++);
        int k = list.size()-1;
        System.out.println(index);
        List<Integer> sc = new ArrayList<>();
        while(k>=0){
            sc.add(list.get(k).get(index));
            index = index / 2;
            k--;
        }
        for(List<Integer> ls:list){
            for (Integer a:ls){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        List<Integer> newSc = new ArrayList<>();
        for (int j=0;j<sc.size();j++){
            newSc.add(sc.get(sc.size()-1-j));
        }
        return newSc;
    }
}
