package com.azhi.thread.singleton;

/**
 * @author azhi
 * 2021/4/9 6:30 下午
 */
public class Singleton2 {

    private volatile static Singleton2 uniqueInstance;

    private Singleton2() {
    }

    public static Singleton2 getUniqueInstance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }

}
