package com.lzq.leetcode.Number;

import java.util.*;

public class kthLargestNumber {
    public static String kthLargestNumber(String[] nums, int k) {
        List<String> list = new ArrayList<>(Arrays.asList(nums));
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()!=o2.length()?o2.length()-o1.length():o2.compareTo(o1);
            }
        });
        return list.get(k-1);
    }

    public static void main(String[] args) {
        System.out.println(kthLargestNumber(new String[]{"2","21","12","1"},3));
    }
}
