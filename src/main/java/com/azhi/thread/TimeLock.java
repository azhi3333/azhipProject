package com.azhi.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 现实等待锁对使用
 * @author azhi
 * 2021/3/25 6:20 下午
 */
public class TimeLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            System.out.println("current thread name " + Thread.currentThread().getName());
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                Thread.sleep(6000);
            } else {
                System.out.println("get lock faild "+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLock tl = new TimeLock();
        Thread thread = new Thread(tl);
        thread.setName("test1");
        Thread thread1 = new Thread(tl);
        thread1.setName("test2");
        thread.start();
        thread1.start();

    }
}
