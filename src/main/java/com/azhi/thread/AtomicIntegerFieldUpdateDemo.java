package com.azhi.thread;

import com.azhi.thread.ch4.AtomicIntegerFieldUpdaterDemo;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author azhi
 * 2021/3/30 1:57 下午
 */
public class AtomicIntegerFieldUpdateDemo {
    public static class Candidate{
        int id;
        volatile int sore;
    }

    public final static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterDemo.Candidate> scoreUpdater
            = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterDemo.Candidate.class, "score");

}
