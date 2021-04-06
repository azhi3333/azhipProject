package com.azhi.thread.lock;

import java.util.concurrent.locks.LockSupport;

/**
 *
 * 线程阻塞类
 * 在线程内任意位置让线程阻塞
 * @author azhi
 * 2021/3/31 1:14 下午
 */
public class LockSupportIntDemo {

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
                //将当前调用Thread阻塞
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println(getName() + "被中断了");
                }
            }
            System.out.println(getName()+"执行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.interrupt();
        //将指定线程Thread唤醒
        LockSupport.unpark(t2);
    }
}





