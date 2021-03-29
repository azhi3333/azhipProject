package com.azhi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 * // TODO: 2021/3/29  
 * 适用场景：有一家蛋糕店，为了挽留客户，决定为VIP卡里余额小于20元的客户一次性赠送20元。
 * @author azhi
 * 2021/3/29 10:52 上午
 */
public class TopUpAccount {

    static AtomicReference<Integer> money = new AtomicReference<>();

    public static void setMoney(int index) {
        money.set(index);
    }

    public static class ChargeMoney implements Runnable{
        @Override
        public void run() {
            while (true) {
                while (true) {
                    Integer m = money.get();
                    if ( m < 20) {
                        if (money.compareAndSet(m,m+20)) {
                            System.out.println("余额小于20元，充值成功，余额：" + money.get() + "元");
                            break;
                        }
                    } else {
                        System.out.println("余额大于20元，无须充值");
                        break;
                    }
                }
            }
        }
    }

    public static class  ConsumeMoney implements Runnable{
        @Override
        public void run() {

            while (true) {
                Integer m = money.get();
                if ( m > 10) {
                    System.out.println("大于10元");
                    if (money.compareAndSet(m,m-10)) {
                        System.out.println("成功消费10元，余额：" + money.get() + "元");
                        break;
                    }
                } else {
                    System.out.println("没有足够的金额");
                    break;
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        setMoney(11);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new ConsumeMoney());
        }
        for (int i = 0; i < 3; i++) {
            executorService.execute(new ChargeMoney());
        }
        executorService.shutdown();
    }
}
