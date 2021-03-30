package com.azhi.thread.Singleton;

/**
 * @author azhi
 * 2021/3/30 3:59 下午
 */
public class StaticSingleton {
    public StaticSingleton() {
        System.out.println("StaticSingleton is create!");
    }

    private static class StaticSingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return StaticSingletonHolder.instance;
    }
}
