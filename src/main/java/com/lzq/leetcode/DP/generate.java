package com.lzq.leetcode.DP;

import java.util.ArrayList;
import java.util.List;

public class generate {
    public static void main(String[] args) {
        List<List<Integer>> ls = generate(10);
        for(int i=0;i<ls.size();i++){
            for(int j=0;j<ls.get(i).size();j++){
                System.out.print(ls.get(i).get(j)+" ");
            }
            System.out.println();
        }
        List<Integer> ll = getRow(0);
        for(int i=0;i<ll.size();i++){
            System.out.print(ll.get(i)+" ");
        }

    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        if(numRows==0) return ls;
        for(int i=1;i<=numRows;i++){
            List<Integer> ll = new ArrayList<Integer>();
            ll.add(1);
            if(i>1){
                List<Integer> last = ls.get(ls.size()-1);
                for(int j=1;j<i-1;j++){
                    Integer cur = last.get(j-1)+last.get(j);
                    ll.add(cur);
                }
                ll.add(1);
            }
            ls.add(ll);
        }
        return ls;
    }
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        for(int i=1;i<=rowIndex+1;i++){
            List<Integer> ll = new ArrayList<Integer>();
            ll.add(1);
            if(i>1){
                List<Integer> last = ls.get(ls.size()-1);
                for(int j=1;j<i-1;j++){
                    Integer cur = last.get(j-1)+last.get(j);
                    ll.add(cur);
                }
                ll.add(1);
            }
            ls.add(ll);
        }
        return ls.get(rowIndex);
    }
}
