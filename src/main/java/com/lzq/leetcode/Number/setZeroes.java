package com.lzq.leetcode.Number;

import java.util.HashSet;
import java.util.Set;

public class setZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    list1.add(i);
                    list2.add(j);
                }
            }
        }
        for(int i = 0;i<matrix.length;i++){
            if(list1.contains(i))
                for (int j = 0; j < matrix[i].length; j++){
                    matrix[i][j] = 0;
                }
        }
        for(int i = 0;i<matrix[0].length;i++){
            if(list2.contains(i))
                for (int j = 0; j < matrix.length; j++){
                    matrix[j][i] = 0;
                }
        }
    }
}
