package com.lzq.leetcode.Map;

import java.util.HashMap;
import java.util.Map;

public class isHappy {
    public boolean isHappy(int n) {
        Map<Integer,Boolean> map = new HashMap<>();
        int sum = n;
        while(!map.containsKey(sum)){
            int cnt = 0;
            map.put(sum,true);
            while(sum!=0){
                cnt = cnt + (sum % 10) * (sum % 10);
                sum = sum / 10;
            }
            sum = cnt;
            if(sum==1) return true;
        }
        return false;
    }
}
