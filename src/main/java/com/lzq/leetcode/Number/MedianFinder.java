package com.lzq.leetcode.Number;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    /*
    * 9 8 7 6 5 4 3 2 1
    * 8 9
    * 7 6
    * */
    Queue<Integer> queueMin;
    Queue<Integer> queueMax;
    public MedianFinder() {
        queueMin = new PriorityQueue<>((a,b)->{return a-b;});
        queueMax = new PriorityQueue<>((a,b)->{return b-a;});
    }

    public void addNum(int num) {
        if(queueMin.isEmpty()||queueMin.peek()<=num)
            queueMin.add(num);
        else queueMax.add(num);
        if(queueMin.size()-queueMax.size()>1){
            queueMax.add(queueMin.poll());
        }
        if(queueMax.size()-queueMin.size()>1){
            queueMin.add(queueMax.poll());
        }
    }

    public double findMedian() {
        if((queueMin.size()+queueMax.size())%2==0){
            return (queueMax.peek() + queueMin.peek())/2.0;
        }else{
            return queueMin.size()>queueMax.size()?queueMin.peek():queueMax.peek();
        }
    }
}
