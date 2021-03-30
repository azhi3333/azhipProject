package com.azhi.thread.producerConsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author azhi
 * 2021/3/30 4:25 下午
 */
public class Consumer implements Runnable{


    private BlockingQueue<PCData> queue;
    private static final int SLEEP_TIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        System.out.println("start Consumer id = " + Thread.currentThread().getId());
        Random random = new Random();


        try {
            while (true) {
                PCData pcData = queue.take();
                if (pcData != null) {
                    int re = pcData.getIntData() * pcData.getIntData();
                    System.out.println(MessageFormat.format("{0}*{1} = {2}",
                            pcData.getIntData(),pcData.getIntData(),re));
                    Thread.sleep(random.nextInt(SLEEP_TIME));
                }
            }
        }  catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }


    }
}
