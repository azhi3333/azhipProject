package com.azhi.thread.producerConsumer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author azhi
 * 2021/3/30 4:30 下午
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingDeque<>(10);
        Producer prCropPeer = new Producer(queue);
        Producer prCropPeer1 = new Producer(queue);
        Producer prCropPeer2 = new Producer(queue);
        Producer prCropPeer3 = new Producer(queue);

        Consumer consumer = new Consumer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2= new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(prCropPeer);
        executorService.execute(consumer);/*
        executorService.execute(prCropPeer1);
        executorService.execute(prCropPeer2);
        executorService.execute(prCropPeer3);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);*/
        Thread.sleep(10000);
        executorService.shutdown();

    }
}
