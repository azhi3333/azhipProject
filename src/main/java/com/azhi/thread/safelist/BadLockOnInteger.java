package com.azhi.thread.safelist;

/**
 * @author azhi
 * 2021/3/24 9:51 下午
 */
public class BadLockOnInteger implements Runnable{

    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();
    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            //错误示范
            //            synchronized (i) {
            synchronized (instance) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(instance);
        Thread thread1 = new Thread(instance);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(i);
    }
}
