package com.azhi.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author azhi
 * 2021/3/29 10:29 上午
 */
public class AtomicIntegerDemo {
    static AtomicInteger integer = new AtomicInteger();
    public static class AddThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                integer.incrementAndGet();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Runnable target = new AddThread();
            ts[i] = new Thread(target);
        }
//        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            ts[i].start();
        }
        for (int i = 0; i < 10; i++) {
            ts[i].join();
        }
        System.out.println(integer);
    }
}
