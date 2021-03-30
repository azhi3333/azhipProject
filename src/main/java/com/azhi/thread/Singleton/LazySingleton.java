package com.azhi.thread.Singleton;

/**
 * @author azhi
 * 2021/3/30 3:52 下午
 */
public class LazySingleton {

    public LazySingleton() {
        System.out.println("singleton is create!");
    }
    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
