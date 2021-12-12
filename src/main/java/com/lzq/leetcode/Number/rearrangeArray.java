package com.lzq.leetcode.Number;

import java.util.ArrayList;
import java.util.List;

public class rearrangeArray {
    public static List<Integer> list = new ArrayList<>();
    public static int[] rearrangeArray(int[] nums) {
        dfs(nums,new ArrayList<>(),new boolean[nums.length]);
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;res[i]=list.get(i),i++);
        return res;
    }
    public static void dfs(int[] nums,List<Integer> ls,boolean[] used){
        if(ls.size()==nums.length){
            list.addAll(ls);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.size()==nums.length) break;
            if(used[i]) continue;
            if(ls.size()<2){
                used[i] = true;
                ls.add(nums[i]);
            }
            else{
                if(ls.get(ls.size()-2)+nums[i]==ls.get(ls.size()-1)*2)
                    continue;
                else{
                    used[i] = true;
                    ls.add(nums[i]);
                }
            }
            dfs(nums,ls,used);
            used[i] = false;
            ls.remove(ls.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] res = rearrangeArray(new int[]{6,2,0,9,7});
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
