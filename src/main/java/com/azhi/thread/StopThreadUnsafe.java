package com.azhi.thread;

import lombok.Data;
import lombok.ToString;

/**
 *
 * 终止线程操作
 * @author azhi
 * 2021/3/23 9:26 下午
 */
public class StopThreadUnsafe {
    public static User u = new User();

    @Data
    @ToString
    public static class User{
        private int id;
        private String name;
        public User(){
            id = 0;
            name = "0";
        }
    }

    public static class ChangeObjectThread extends Thread{
        volatile boolean stopMe = false;

        public void stopMe(){
            stopMe = true;
        }

        @Override
        public void run() {
            while (true) {
                if (stopMe) {
                    System.out.println("exit by stop  me");
                    break;
                }
                synchronized (u) {
                    int v= (int) System.currentTimeMillis()/1000;
                    u.setId(v);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }

    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while (true) {
                synchronized (u){
                    if (u.getId() != Integer.parseInt(u.getName())) {
                        System.out.println(u.toString());
                    } else {
                        System.out.println(u.getId() + "+ id equals name!");
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            ChangeObjectThread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            //错误的停止线程的方式
            //t.stop();
            //正确操作
            t.stopMe();
        }
    }
}
