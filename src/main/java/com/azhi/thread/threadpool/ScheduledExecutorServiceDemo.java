package com.azhi.thread.threadpool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author azhi
 * 2021/3/28 4:44 下午
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);
//        executorService.scheduleAtFixedRate(() -> {
//            try {
//                Thread.sleep(1000);
//                System.out.println(System.currentTimeMillis()/1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        },0,2, TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(() -> {
            try {
                Thread.sleep(8000);
                System.out.println(System.currentTimeMillis()/1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },0,2,TimeUnit.SECONDS);
    }
}
