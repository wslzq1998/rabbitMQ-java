package com.lzq.leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class countArrangement {
    public static int sum = 0 ;
    public static int countArrangement(int n) {
        dfs(n,1,new boolean[n+1],new ArrayList<>());
        return sum;
    }
    public static void dfs(int n, int k, boolean[] used, List<Integer> ls){
        if(k==n+1){
            for(Integer inte:ls) System.out.print(inte+" ");
            System.out.println();
            sum++; return;
        }
        for(int i=1;i<=n;i++){
            if(used[i]) continue;
            if(i%k==0||k%i==0){
                used[i] = true;
                List<Integer> newLs = new ArrayList<>(ls);
                newLs.add(i);
                dfs(n,k+1,used,newLs);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(9));
    }
}
