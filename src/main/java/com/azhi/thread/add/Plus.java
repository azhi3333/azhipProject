package com.azhi.thread.add;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author azhi
 * 2021/3/30 5:07 下午
 */
public class Plus implements Runnable{
    public static BlockingQueue<Msg> queue = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = queue.take();
                msg.j = msg.i + msg.j;
                Multiply.queue.add(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
