package com.azhi.thread.Singleton;

/**
 * @author azhi
 * 2021/3/30 3:49 下午
 */
public class Singleton {
    public Singleton() {
        System.out.println("singleton is create!");
    }
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}
