package com.lzq.leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

* */
public class minimumTotal {
    public static void main(String[] args) {
        //{{2},{3,4},{6,5,7},{4,1,8,3}}
        List ls1 = new ArrayList(Arrays.asList(-1));
        List ls2 = new ArrayList(Arrays.asList(3,2));
        List ls3 = new ArrayList(Arrays.asList(-3,1,-1));
        List ls4 = new ArrayList(Arrays.asList(4,1,8,3));
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(ls1);
        list.add(ls2);
        list.add(ls3);
//        list.add(ls4);
        System.out.println(minimumTotal(list));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(triangle.get(0));
        int minn = Integer.MAX_VALUE;
        for(int i=1;i<triangle.size();i++){
            List<Integer> ls = new ArrayList<Integer>();
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0||j==triangle.get(i).size()-1){
                    int y = j==0?0:triangle.get(i-1).size()-1;
                    ls.add(triangle.get(i).get(j)+list.get(i-1).get(y));
                }else {
                    ls.add(triangle.get(i).get(j)+Math.min(list.get(i-1).get(j-1),list.get(i-1).get(j)));
                }
            }
            list.add(ls);
        }
        for(int i=0;i<list.size();i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
        for(int i=0;i<list.get(list.size()-1).size();i++){
            minn = Math.min(list.get(list.size()-1).get(i),minn);
        }
        return minn;
    }
}
