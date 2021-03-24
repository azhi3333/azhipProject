package com.azhi.thread;

/**
 * @author azhi
 * 2021/3/24 8:41 下午
 */
public class AccountingVol implements Runnable{

    static AccountingVol instance = new AccountingVol();
    static volatile int i = 0 ;
    /**
     * 2。锁静态方法
     */
    public synchronized static void increase(){
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }

        //1。直接作用于实例方法
        //for (int j = 0; j < 10000000; j++) {
        //            synchronized (instance) {
        //                increase();
        //                }
        //}

    }

    public static void main(String[] args) throws InterruptedException {

        //如果使用不同对象。可以锁静态方法
        Thread t1 = new Thread(new AccountingVol());
        Thread t2 = new Thread(new AccountingVol());


        //实现线程安全方法
        //1。直接作用于实例方法
        //2。锁静态方法

        //这样是确保同一个对象
//        Thread t1 = new Thread(instance);
//        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        //???为什么join???
        t1.join();
        t2.join();
        System.out.println(i);
        //
    }
}
