package com.azhi.thread;

import sun.awt.windows.ThemeReader;

/**
 * 中断线程
 * @author azhi
 * 2021/3/24 1:17 下午
 */
public class InterruptedThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted!");
                    break;
                }
                try {
                    //todo 不是很理解
                    //Thread.sleep()方法由于中断而抛出异常，此时，它会清除中断标记，如果不加处理，那么在下一次循环开始时候，
                    //就无法捕获这个中断，故在异常处理中，再次设置中断标记位。
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted when sleep");
                    e.printStackTrace();
                    //手动设置中断
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
        });
        t1.start();
        Thread.sleep(2000);
        //中断线程
        t1.interrupt();
    }
}
