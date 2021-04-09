package com.azhi.thread.singleton;

/**
 * @author azhi
 * 2021/3/30 3:49 下午
 */
public class Singleton {
    public static int STATUS = 1;
    private Singleton() {
        System.out.println("singleton is create!");
    }
    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }


    public static void main(String[] args) {

        //在任何地方引用Singleton.STATUS都会使得instance实例被创建
//        Singleton instance = Singleton.getInstance();
        System.out.println(Singleton.STATUS);
    }
}
