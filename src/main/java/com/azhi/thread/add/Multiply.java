package com.azhi.thread.add;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author azhi
 * 2021/3/30 5:10 下午
 */
public class Multiply implements Runnable {
    public static BlockingQueue<Msg> queue = new LinkedBlockingDeque<>();


    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = queue.take();
                msg.j = msg.i * msg.j;
                Div.queue.add(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
