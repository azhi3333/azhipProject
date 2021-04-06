package com.azhi.thread.lock;

import com.azhi.thread.base.BadSuspend;

import java.util.concurrent.locks.LockSupport;

/**
 * todo 老子不大懂
 * 线程阻塞类
 * 在线程内任意位置让线程阻塞
 * @author azhi
 * 2021/3/31 1:14 下午
 */
public class LockSupportDemo {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
