package com.azhi.thread.singleton;

/**
 * 支持延迟加载的策略
 * @author azhi
 * 2021/3/30 3:52 下午
 */
public class LazySingleton {

    public LazySingleton() {
        System.out.println("singleton is create!");
    }
    private static LazySingleton instance = null;

    //synchronized充分实现了延迟加载
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
