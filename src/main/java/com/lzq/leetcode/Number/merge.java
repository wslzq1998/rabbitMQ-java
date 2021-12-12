package com.lzq.leetcode.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class merge {
    public static class Node{
        int left;
        int right;
    }
    public static int[][] merge(int[][] intervals) {
        List<Node> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            Node node = new Node();
            node.left = intervals[i][0];
            node.right = intervals[i][1];
            list.add(node);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.left==o2.left){
                    return o1.right-o2.right;
                }else{
                    return o1.left-o2.left;
                }
            }
        });
        int left = list.get(0).left,right = list.get(0).right;
        List<Node> ls = new ArrayList<>();
        for(int i=1;i<list.size();i++){
            if(right<list.get(i).left){
                Node node = new Node();
                node.left = left;
                node.right = right;
                ls.add(node);
                left = list.get(i).left;
                right = list.get(i).right;
            }else{
                right = Math.max(right,list.get(i).right);
            }
        }
        Node node = new Node();
        node.left = left;
        node.right = right;
        ls.add(node);
        int[][] newIntervals = new int[ls.size()][2];
        for(int i=0;i<ls.size();i++){
            newIntervals[i][0] = ls.get(i).left;
            newIntervals[i][1] = ls.get(i).right;
        }
        return newIntervals;
    }

    public static void main(String[] args) {
        int[][] newIntervals = merge(new int[][]{{1,2},{2,6},{8,10},{9,18}});
        for(int i=0;i<newIntervals.length;i++){
            System.out.println(newIntervals[i][0]+" "+newIntervals[i][1]);
        }
    }
}
