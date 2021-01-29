package com.bwone.pattern.singleton;

public class LazySingleton {

    private static volatile LazySingleton instance = null;

    private LazySingleton() {

    }

    /**
     * 同步(性能较差)
     */
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 双重检查锁
     */
    public static LazySingleton getInstance2() {
        if (instance == null) {
            synchronized (LazySingleton.class){
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

}
