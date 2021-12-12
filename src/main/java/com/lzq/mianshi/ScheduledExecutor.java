package com.lzq.mianshi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void test(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        pool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("运行时间: " + sdf.format(new Date()));
            }
        },0,3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        test();
    }
}
