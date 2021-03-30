package com.azhi.thread.add;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author azhi
 * 2021/3/30 5:10 下午
 */
public class Div implements Runnable{

    public static BlockingQueue<Msg> queue = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = queue.take();
                msg.i = msg.i / 2;
                System.out.println(msg.orgString  + " = " + msg.i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
