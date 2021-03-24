package com.azhi.thread;

/**
 * @author azhi
 * 2021/3/24 2:24 下午
 */
public class JoinMain {
    public volatile static int i=0;
    public static class AddThread extends Thread{
        @Override
        public void run() {
            for ( i= 0; i < 10000000; i++){};
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        //等待线程结束再加入
        at.join();
//        at.wait();
        System.out.println(i);
    }
}
