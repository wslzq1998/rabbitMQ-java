package com.lzq.leetcode.Number;

public class chalkReplacer {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0,kk = k;
        for(int i=0;i<chalk.length;i++) sum+=chalk[i];
        kk = kk % sum;
        for(int i=0;i<chalk.length;i++){
            if(kk<chalk[i]) return i;
            kk = kk - chalk[i];
        }
        return 0;
    }
}
