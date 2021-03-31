package com.azhi.thread.add;

import lombok.extern.slf4j.Slf4j;


/**
 * 流水线思想
 * @author azhi
 * 2021/3/30 5:14 下午
 */
@Slf4j
public class StreamMain {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.orgString = "(( "+ i + "+" + j + " ) * " +   i  + ")/2";
                Plus.queue.add(msg);
            }
        }
        //todo ????
        System.out.println("use time " + (System.currentTimeMillis() - l));
    }
}
