package com.azhi.thread.threadpool;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author azhi
 * 2021/3/28 5:36 下午
 */
public class MyTraceThreadExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0,Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            poolExecutor.execute(new DivTask(100,i));
        }
    }
}
