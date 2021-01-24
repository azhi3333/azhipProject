package com.azhi.thread;

/**
 * created by @Author: azhi on @Date: 2021/1/24 12:59 下午
 */
public class BadSuspend {
    public static Object u = new Object();
    static BadSuspend.ChangeObjectThread t1 = new BadSuspend.ChangeObjectThread("t1");
    static BadSuspend.ChangeObjectThread t2 = new BadSuspend.ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name){
            super.setName(name);
        }
        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in "+getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }
}
