package com.lzq.leetcode.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class splitPainting {
    public static void main(String[] args) {
        List<List<Long>> list = splitPainting(new int[][]{{1,4,5},{4,7,7},{2,7,9}});
    }
    public static List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> list = new ArrayList<>();
        Arrays.sort(segments,((o1, o2) -> {
            if(o1[0]>o2[0]) return 1;
            else if(o1[0]==o2[0]) return o1[1]-o2[1];
            else return -1;
        }));

        return list;
    }
}
