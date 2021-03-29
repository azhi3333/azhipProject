package com.azhi.thread.threadpool;

/**
 * @author azhi
 * 2021/3/28 5:34 下午
 */
public class DivTask implements Runnable{
    int a;
    int b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a/b;
        System.out.println(re);
    }
}
