package com.lzq.mianshi;

import javafx.print.Collation;

import java.util.*;

public class solution {
    public static int[] solution(int[] nums,int k,int x){
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                index = i;
                break;
            }else{
                if(i<nums.length-1&&nums[i]<x&&nums[i+1]>x){
                    index = i; break;
                }
            }
        }
        if(nums[0]>x) index = 0;
        if(nums[nums.length-1]<x) index = nums.length-1;

        int left=index,right=index+1;
        int[] res = new int[k];
        int cur = 0;
        while(left>=0&&right<nums.length){
            if(x-nums[left]<=nums[right]-x){
                res[cur] = nums[left]; left--;
            }else{
                res[cur] = nums[right]; right++;
            }
            cur++;
        }
        if(cur<k){
            while(left>=0&&cur<k){
                res[cur] = nums[left];
                left--; cur++;
            }
            while(right<nums.length&&cur<k){
                res[cur] = nums[right];
                left++; cur++;
            }
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int[] res = solution(new int[]{1,2,3,4,5},4,3);
//        for(int i=0;i<res.length;i++)
//            System.out.println(res[i]);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(2);ls.add(2);ls.add(5);
        list.add(ls);
        ArrayList<Integer> ls2 = new ArrayList<>();
        ls2.add(2);ls2.add(1);ls2.add(5);
        list.add(ls2);
        System.out.println(solution3(list,2));
    }
    public static int[] solution2(int[] nums){
        int[] res = new int[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i+=2){
            if(nums[i]!=nums[i+1]){
                res[0] = nums[i];
                res[1] = nums[i+1];
            }
        }
        return res;
    }
    public static boolean solution3(ArrayList<ArrayList<Integer>> lists, int k){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(ArrayList<Integer> ls:lists){
            ArrayList<Integer> newLs1 = new ArrayList<>();
            newLs1.add(ls.get(0));
            newLs1.add(ls.get(1));
            newLs1.add(0);//拿
            ArrayList<Integer> newLs2 = new ArrayList<>();
            newLs2.add(ls.get(0));
            newLs2.add(ls.get(2));
            newLs2.add(1);//放
            list.add(newLs1);
            list.add(newLs2);
        }
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(1)-o2.get(1);
            }
        });
        int curr = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).get(2)==0){
                curr+=list.get(i).get(0);
            }else{
                curr-=list.get(i).get(0);
            }
            if(curr>k) return false;
        }
        return true;
    }
}
