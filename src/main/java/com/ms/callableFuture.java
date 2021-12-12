package com.ms;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class callableFuture {
    public static void main(String[] args) {
        MyThead m1 = new MyThead();
        MyThead m2 = new MyThead();
        FutureTask<String> task1 = new FutureTask<String>(m1);
        FutureTask<String> task2 = new FutureTask<String>(m2);
        //FutureTask是Runnable接口的实现类/子类，所以Thread构造方法可以接收其对象
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
    }
}
class MyThead implements Callable<String> {
    private int ticket=10;
    public String call() throws Exception {
        for(int i=0;i<200;i++){
            if(this.ticket>0){
                System.out.println("ticket="+ticket--);
            }
        }
        return "";
    }
}
