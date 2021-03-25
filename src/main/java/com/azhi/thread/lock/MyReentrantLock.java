package com.azhi.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 重入锁
 * @author azhi
 * 2021/3/25 5:32 下午
 */
public class MyReentrantLock implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {

        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyReentrantLock myReentrantLock = new MyReentrantLock();
        Thread t1 = new Thread(myReentrantLock);
        Thread t2 = new Thread(myReentrantLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
