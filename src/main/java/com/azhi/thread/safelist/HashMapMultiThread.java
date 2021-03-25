package com.azhi.thread.safelist;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author azhi
 * 2021/3/24 9:33 下午
 */
public class HashMapMultiThread {
    static Map<String, String> map = new ConcurrentHashMap<>();
    public static class AddThread implements Runnable{

        int start = 0;
        public AddThread(int start){
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100000; i++) {
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new HashMapMultiThread.AddThread(0));
        Thread thread1 = new Thread(new HashMapMultiThread.AddThread(1));
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(map.size());
    }
}
