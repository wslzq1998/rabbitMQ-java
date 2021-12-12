package com.lzq.leetcode.Number;

import java.util.Arrays;

public class numRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0,j = people.length-1;
        int sum = 0;
        while(i<=j){
            if(i==j){
                if(people[i]<=limit) sum++;
                break;
            }
            if(people[i]+people[j--]>limit) sum++;
            else{
                i++; j--; sum++;
            }
        }
        return sum;
    }
}
