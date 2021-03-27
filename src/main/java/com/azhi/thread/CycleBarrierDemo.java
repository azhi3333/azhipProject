package com.azhi.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author azhi
 * 2021/3/27 1:34 下午
 */
public class CycleBarrierDemo {

    public static class Soldier implements Runnable{
        private String soldier;
        private final CyclicBarrier cyclicBarrier;

        public Soldier(CyclicBarrier cyclicBarrier,String soldierName) {
            this.cyclicBarrier = cyclicBarrier;
            this.soldier = soldierName;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
                //调两遍 根据flag判断是否集合还是完成任务
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork(){
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
                System.out.println(soldier + ":任务完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static class BarrierRun implements Runnable{
            boolean flag;
            int N;

            public BarrierRun(boolean flag, int n) {
                this.flag = flag;
                N = n;
            }
            @Override
            public void run() {
               if (flag) {
                   System.out.println("司令：「士兵」" + N + "个任务完成！");
               } else {
                   System.out.println("司令：「士兵」" + N + "个集合完毕！");
                   flag = true;
               }
            }
        }
        public static void main(String[] args) {
            final int n = 5;
            ExecutorService executor = Executors.newFixedThreadPool(n);
            CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new BarrierRun(false,n));
            System.out.println("队伍集合！");
            for (int i = 0; i < n; i++) {
                System.out.println("士兵" + i + " 报道");
                executor.submit(new Soldier(cyclicBarrier,"士兵 " + i));
            }
        }
    }
}
