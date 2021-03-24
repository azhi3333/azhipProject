package com.azhi.thread;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author azhi
 * 2021/3/24 9:22 下午
 */
public class ArrayListMultiThread {
    static Vector<Integer> arrayList = new Vector<>(10);
    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                arrayList.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread());
        Thread thread2 = new Thread(new AddThread());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(arrayList.size());
    }
}
