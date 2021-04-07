package com.azhi.thread;

import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal 线程的局部变量，即每个线程都有的
 * 使用场景：
 * @author azhi
 * 2021/4/7 10:49 上午
 */
public class SimpleDateFormatTest {

    //
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
    public static class ParseDate implements Runnable{
        public ParseDate(int i) {
            this.i = i;
        }

        int i = 0;
        @SneakyThrows(ParseException.class)
        @Override
        public void run() {

            if (threadLocal.get() == null) {
                threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
            Date parse = threadLocal.get().parse("2020-03-29 12:34:" + i % 60);
            System.out.println(i + ":" + parse);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ParseDate(i));

        }
    }
}
