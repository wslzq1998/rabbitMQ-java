package com.lzq.leetcode.Number;

public class timeRequiredToBuy {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        while(true){
            for(int i=0;i<tickets.length;i++){
                if(i==k&&tickets[i]==1) return res+1;
                if(tickets[i]!=0){
                    res = res + 1;
                    tickets[i] = tickets[i] - 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2,3,2},2));
    }
}
