package com.azhi.thread.producerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author azhi
 * 2021/3/30 4:11 下午
 */
public class Producer implements Runnable{
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;
    private static final int SLEEP_TIME = 1000;
    private static AtomicInteger count  = new AtomicInteger();

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData pcData;
        Random random = new Random();
        System.out.println("start producer id = " + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(random.nextInt(SLEEP_TIME));
                pcData = new PCData(count.incrementAndGet());
                System.out.println(pcData + "is put into queue");
                if (queue.offer(pcData,2, TimeUnit.SECONDS)) {
                    System.err.println("failed to put data " + pcData);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    public void stop(){
        isRunning = false;
    }
}
