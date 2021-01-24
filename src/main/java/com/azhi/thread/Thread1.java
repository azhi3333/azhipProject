package com.azhi.thread;

public class Thread1 implements Runnable{


    public static void main(String[] args) {
        Thread thread = new Thread(new Thread1());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("oh, i am runable");
    }
}
